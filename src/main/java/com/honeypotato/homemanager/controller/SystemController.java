package com.honeypotato.homemanager.controller;

import com.honeypotato.homemanager.aop.AnnotationLog;
import com.honeypotato.homemanager.common.LogUtil;
import com.honeypotato.homemanager.common.RetFactory;
import com.honeypotato.homemanager.common.model.RetResult;
import com.honeypotato.homemanager.model.User;
import com.honeypotato.homemanager.service.base.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统
 *
 * @author sanyihwang.
 * created on 2018/9/27
 **/
@RestController
public class SystemController {

    @Autowired
    private ShiroService shiroService;

    @PostMapping("/login")
    @AnnotationLog
    public RetResult login(String userName, String password) {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(new UsernamePasswordToken(userName, password));
        User user = (User) currentUser.getPrincipal();
        return RetFactory.success(user);
    }

    @GetMapping("/noLogin")
    public void noLogin() {
        throw new UnauthenticatedException();
    }

    @GetMapping("/noAuthorize")
    public void noAuthorize() {
        throw new UnauthorizedException();
    }

    @PostMapping("/nowUser")
    public User getNowUser() {
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    @PostMapping("/updatePermission")
    public void updatePermission() throws Exception {
        shiroService.reloadShiro();
    }

}
