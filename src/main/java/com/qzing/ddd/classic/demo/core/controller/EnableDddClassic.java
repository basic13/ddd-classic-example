package com.qzing.ddd.classic.demo.core.controller;

import com.qzing.ddd.classic.demo.core.controller.request.RequestBodyValidateAdvice;
import com.qzing.ddd.classic.demo.core.controller.response.ExceptionResponseHandler;
import com.qzing.ddd.classic.demo.core.controller.response.NormalResponseAdvice;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author yangyanze
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({
        Test.class,
        AutoControllerScannerRegistrar.class,
        NormalResponseAdvice.class,
        ExceptionResponseHandler.class,
        RequestBodyValidateAdvice.class
})
public @interface EnableDddClassic {
}
