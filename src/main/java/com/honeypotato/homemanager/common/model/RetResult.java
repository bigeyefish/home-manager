package com.honeypotato.homemanager.common.model;

import lombok.Data;
import lombok.NonNull;

/**
 * 返回对象实体
 * Created by sanyihwang on 2018/9/20.
 **/
@Data
public class RetResult<T> {

    @NonNull
    public int code;

    private String msg;

    private T data;

    public RetResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
