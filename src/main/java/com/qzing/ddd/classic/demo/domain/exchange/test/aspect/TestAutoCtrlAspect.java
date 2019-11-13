package com.qzing.ddd.classic.demo.domain.exchange.test.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author yangyanze
 */
@Aspect
@Component
@Slf4j
public class TestAutoCtrlAspect {
    @Pointcut("execution(public * com.qzing.ddd.classic.demo.domain.exchange.test.app.AutoCtrlAppService.test3(..))")
    public void test() {
    }

    @Around("test()")
    public Object check(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.getArgs()[0] = joinPoint.getArgs()[0] + "aaaaa";
        return joinPoint.proceed(joinPoint.getArgs());
    }
}