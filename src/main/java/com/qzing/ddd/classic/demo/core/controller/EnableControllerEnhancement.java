package com.qzing.ddd.classic.demo.core.controller;

import com.qzing.ddd.classic.demo.core.controller.automapping.AutoControllerScannerRegistrar;
import com.qzing.ddd.classic.demo.core.controller.request.ValidateRequestBodyAdvice;
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
        AutoControllerScannerRegistrar.class,
        NormalResponseAdvice.class,
        ExceptionResponseHandler.class,
        ValidateRequestBodyAdvice.class
})
public @interface EnableControllerEnhancement {
}
