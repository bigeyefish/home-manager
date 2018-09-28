package com.honeypotato.homemanager.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Role {
    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 角色名称，用于显示
     */
    private String name;

    /**
     * 角色描述
     */
    private String desc;

    /**
     * 角色值，用于权限判断
     */
    private String value;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否禁用
     */
    @Column(name = "is_disable")
    private Integer isDisable;
}