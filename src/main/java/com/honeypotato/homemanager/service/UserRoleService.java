package com.honeypotato.homemanager.service;

import com.honeypotato.homemanager.dao.UserRoleMapper;
import com.honeypotato.homemanager.model.UserRole;
import com.honeypotato.homemanager.service.base.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色服务类
 *
 * @author sanyihwang.
 * created on 2018/9/27
 **/
@Service
public class UserRoleService extends AbstractServiceImpl<UserRole> {

    @Resource
    private UserRoleMapper userRoleMapper;

    public List<String> getRolesByUserId(String userId) {
        return userRoleMapper.getRolesByUserId(userId);
    }

}
