package com.qzing.ddd.classic.demo.core.controller;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
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

    @AliasFor(annotation = Component.class)
    String value() default "";
}
