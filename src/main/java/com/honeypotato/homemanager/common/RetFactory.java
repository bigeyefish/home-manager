package com.honeypotato.homemanager.common;

import com.honeypotato.homemanager.common.model.ResultEnum;
import com.honeypotato.homemanager.common.model.RetResult;

/**
 * web返回结果数据工厂类
 * Created by sanyihwang on 2018/9/20.
 **/
public class RetFactory {
    /**
     * 构建接口成功返回数据
     * @param data
     * @return
     */
    public static <T> RetResult success(T data) {
        return RetFactory.createResult(ResultEnum.SUCCESS, data);
    }

    /**
     * 构建接口程序异常返回数据
     * @param data
     * @return
     */
    public static RetResult error(Object data) {
        return RetFactory.createResult(ResultEnum.ERROR, data);
    }

    /**
     * 构建接口返回数据
     * @param result 返回码
     * @param data 业务数据
     * @return
     */
    public static <T> RetResult createResult(ResultEnum result, T data) {
        return new RetResult<>(result.getCode(), result.getMsg(), data);
    }

    /**
     * 构建接口返回数据
     * @param result 返回码
     * @return
     */
    public static RetResult createResult(ResultEnum result) {
        return createResult(result, null);
    }
}
