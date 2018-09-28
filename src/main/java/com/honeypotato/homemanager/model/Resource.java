package com.honeypotato.homemanager.model;

import javax.persistence.*;

public class Resource {
    @Id
    private String id;

    /**
     * 程序对应url地址
     */
    private String url;

    /**
     * 对应shiro权限
     */
    private String authorize;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取程序对应url地址
     *
     * @return url - 程序对应url地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置程序对应url地址
     *
     * @param url 程序对应url地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取对应shiro权限
     *
     * @return authorize - 对应shiro权限
     */
    public String getAuthorize() {
        return authorize;
    }

    /**
     * 设置对应shiro权限
     *
     * @param authorize 对应shiro权限
     */
    public void setAuthorize(String authorize) {
        this.authorize = authorize == null ? null : authorize.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}