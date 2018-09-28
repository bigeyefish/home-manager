package com.honeypotato.homemanager.dao;

import com.honeypotato.homemanager.common.Mapper;
import com.honeypotato.homemanager.model.RolePermission;

import java.util.List;

public interface RolePermissionMapper extends Mapper<RolePermission> {

    /**
     * 根据用户id获取权限列表
     * @param userId 用户id
     * @return 权限列表
     */
    List<String> getPermissionByUserId(String userId);
}