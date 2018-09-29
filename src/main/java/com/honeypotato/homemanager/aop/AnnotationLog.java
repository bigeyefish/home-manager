package com.honeypotato.homemanager.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AnnotationLog {
    String topic() default "";
}
