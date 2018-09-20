package com.honeypotato.homemanager.exception;

import java.io.Serializable;

/**
 * 业务类异常
 * Created by Lenovo on 2018/9/21.
 **/
public class ServiceException extends RuntimeException implements Serializable {

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
