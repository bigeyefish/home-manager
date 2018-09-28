package com.honeypotato.homemanager.auth;

import com.honeypotato.homemanager.model.User;
import com.honeypotato.homemanager.service.RolePermissionService;
import com.honeypotato.homemanager.service.UserRoleService;
import com.honeypotato.homemanager.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

/**
 * 自定义查询用户信息、权限及校验等逻辑
 *
 * @author sanyihwang.
 * created on 2018/9/27
 **/
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RolePermissionService rolePermissionService;

    /**
     * 告诉shiro如何根据获取到的用户信息中的密码和盐值来校验密码
     */
    {
        // 设置用于匹配密码的CredentialsMatcher
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        // 加密的次数
        hashedCredentialsMatcher.setHashIterations(1024);
        this.setCredentialsMatcher(hashedCredentialsMatcher);
    }

    /**
     * 定义如何获取用户的角色和权限的逻辑，给shiro做权限判断
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthenticationException("PrincipalCollection method argument cannot be null.");
        }
        User user = (User)getAvailablePrincipal(principals);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(user.getRoles());
        info.setStringPermissions(user.getPermissions());
        return info;
    }

    /**
     * 定义如何获取用户信息的业务逻辑，给shiro做登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String userName = upToken.getUsername();
        if (null == userName) {
            throw new AccountException("null usernames are not allowed by this realm.");
        }
        User userDb = userService.selectBy("userName", userName);
        if (null == userDb) {
            throw new UnknownAccountException("No account found for admin [" + userName + "]");
        }
        // 查询用户的角色和权限存到SimpleAuthenticationInfo中，这样在其他地方
        // SecurityUtils.getSubject().getPrincipal()就能拿出用户的鄋信息，包括角色和权限
        List<String> roles = userRoleService.getRolesByUserId(userDb.getId());
        userDb.setRoles(new HashSet<>(roles));
        List<String> permissions = rolePermissionService.getPermissionByUserId(userDb.getId());
        userDb.setPermissions(new HashSet<>(permissions));

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDb, userDb.getPassword(), getName());
        info.setCredentialsSalt(ByteSource.Util.bytes(userDb.getSalt()));

        return info;
    }
}
