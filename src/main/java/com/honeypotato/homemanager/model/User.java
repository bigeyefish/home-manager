package com.honeypotato.homemanager.model;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 4648544488319469973L;
    @Id
    private Integer id;

    private String userName;

    private String nickName;

    private String password;

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
}