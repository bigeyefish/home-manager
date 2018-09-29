package com.honeypotato.homemanager.common.model;

import com.honeypotato.homemanager.common.Constant;
import lombok.Data;

/**
 * 请求日志实体
 *
 * @author sanyihwang.
 * created on 2018/9/29
 **/
@Data
public class ReqLogInfo {

    private String module;

    private String content;

    private String type;

    private String errClass;

    private String errMessage;

    private String method;

    private String userId;

    private String ip;

    public ReqLogInfo() {
        this.type = Constant.LogType.INFO;
    }

    private String params;
}
