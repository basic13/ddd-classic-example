package com.qzing.ddd.classic.demo.core.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * @author yangyanze
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@ResponseBody
public @interface AppController {
    String app() default "";

    String value() default "";

    RequestMethod[] method() default {};

    boolean restful() default false;

    int priority() default 0;

    String ENDFIX = "AppService";
}
