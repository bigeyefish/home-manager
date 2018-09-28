package com.honeypotato.homemanager.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user_role")
public class UserRole {
    @Id
    private String id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private String roleId;

}