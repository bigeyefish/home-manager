package com.honeypotato.homemanager.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "role_permission")
public class RolePermission {
    @Id
    private String id;

    /**
     * 权限id
     */
    @Column(name = "permission_id")
    private String permissionId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private String roleId;

}