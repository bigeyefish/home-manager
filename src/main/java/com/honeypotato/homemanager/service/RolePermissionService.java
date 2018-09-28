package com.honeypotato.homemanager.service;

import com.honeypotato.homemanager.dao.RolePermissionMapper;
import com.honeypotato.homemanager.model.RolePermission;
import com.honeypotato.homemanager.service.base.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 * @author sanyihwang.
 * created on 2018/9/27
 **/
@Service
public class RolePermissionService extends AbstractServiceImpl<RolePermission> {

    @Resource
    private RolePermissionMapper rolePermissionMapper;

    public List<String> getPermissionByUserId(String userId) {
        return rolePermissionMapper.getPermissionByUserId(userId);
    }

}
