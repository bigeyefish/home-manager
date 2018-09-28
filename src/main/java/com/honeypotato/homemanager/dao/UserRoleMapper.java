package com.honeypotato.homemanager.dao;

import com.honeypotato.homemanager.common.Mapper;
import com.honeypotato.homemanager.model.UserRole;

import java.util.List;

public interface UserRoleMapper extends Mapper<UserRole> {

    /**
     * 根据用户id获取角色数据
     * @param userId 用户id
     * @return 角色列表
     */
    List<String> getRolesByUserId(String userId);
}