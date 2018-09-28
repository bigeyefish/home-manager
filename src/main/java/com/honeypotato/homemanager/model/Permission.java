package com.honeypotato.homemanager.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Permission {
    @Id
    private String id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限描述
     */
    private String desc;

    /**
     * 权限值
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