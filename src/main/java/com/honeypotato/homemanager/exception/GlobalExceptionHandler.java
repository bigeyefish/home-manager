package com.honeypotato.homemanager.exception;

import com.honeypotato.homemanager.common.RetFactory;
import com.honeypotato.homemanager.common.model.ResultEnum;
import com.honeypotato.homemanager.common.model.RetResult;
import lombok.extern.log4j.Log4j2;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 默认全局异常处理类
 * Created by sanyihwang on 2018/9/20.
 **/
@Log4j2(topic = "error")
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "warning")
    public void exception404Handler(HttpServletRequest request) {
        log.error("[{}]试图访问不存在的资源[{}]", request.getRemoteHost(), request.getRequestURI());
    }

    @ExceptionHandler(UnauthenticatedException.class)
    @ResponseBody
    public RetResult unauthenticatedHandler(HttpServletRequest request, Exception e) {
        log.error("[{}]未登录访问资源[{}]", request.getRemoteHost(), request.getRequestURI());
        return RetFactory.createResult(ResultEnum.HAVE_NOT_LOGIN, e.getMessage());
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    @ResponseBody
    public RetResult incorrectCredentialsHandler() {
        return RetFactory.createResult(ResultEnum.LOGIN_FAIL);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseBody
    public RetResult unauthorizedHandler() {
        return RetFactory.createResult(ResultEnum.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RetResult<String> defaultExceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof IOException) {
            log.error("业务异常: " + e.getMessage(), this.getClass());
        }
        return new RetResult<>(ResultEnum.ERROR.getCode(), e.getMessage(), null);
    }
}
