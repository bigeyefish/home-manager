package com.honeypotato.homemanager.aop;

import com.alibaba.fastjson.JSON;
import com.honeypotato.homemanager.common.Constant;
import com.honeypotato.homemanager.common.LogUtil;
import com.honeypotato.homemanager.common.SysUtil;
import com.honeypotato.homemanager.common.model.ReqLogInfo;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * aop记录操作日志
 *
 * @author sanyihwang.
 * created on 2018/9/29
 **/
@Aspect
@Component
@Log4j2(topic = "request")
public class AspectLog {

    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.honeypotato.homemanager.aop.AnnotationLog)")
    public void methodCachePointcut() {
    }

    @Before("methodCachePointcut()")
    public void doBefore(JoinPoint p) {
        reqInfo2log(p, null);
    }

    @AfterThrowing(pointcut = "methodCachePointcut()", throwing = "e")
    public void doAfterThrowing(JoinPoint p, Throwable e) {
        reqInfo2log(p, e);
    }


    public void reqInfo2log(JoinPoint p, Throwable e) {
        ReqLogInfo logInfo = new ReqLogInfo();
        logInfo.setMethod(p.getTarget().getClass() + "." + p.getSignature().getName());
        logInfo.setUserId(SysUtil.currentUserId());
        logInfo.setParams(JSON.toJSONString(p.getArgs()));
        if (null != e) {
            logInfo.setType(Constant.LogType.ERROR);
            logInfo.setErrClass(e.getClass().getName());
            logInfo.setErrMessage(e.getMessage());
        }
        Method method = ClassUtils.getMethod(p.getTarget().getClass(), p.getSignature().getName(), null);
        AnnotationLog annotation = AnnotationUtils.findAnnotation(method, AnnotationLog.class);
        if (!StringUtils.isEmpty(annotation.topic())) {
            LogUtil.getLogger(annotation.topic()).info(logInfo);
        } else {
            log.info(logInfo);
        }
    }
}
