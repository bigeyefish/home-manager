package com.honeypotato.homemanager.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4648544488319469973L;
    @Id
    private String id;

    private String userName;

    private String nickName;

    private String password;

    private String salt;

    private Integer age;

    private Date lastLogin;

    private Integer familyId;

    private Boolean sex;

    private String avatar;

    private String mobile;

    private String email;

    private Boolean isactive;

    private Boolean issuper;

    private Integer createBy;

    private Integer updateBy;

    private Date createTime;

    private Date updateTime;

    private String token;

    private Double score;

    @Transient
    private Set<String> roles;

    @Transient
    private Set<String> permissions;
}