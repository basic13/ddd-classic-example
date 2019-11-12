package com.qzing.ddd.classic.demo.core.controller.response;

import com.qzing.ddd.classic.demo.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

@ControllerAdvice
@Slf4j
public class NormalResponseAdvice implements ResponseBodyAdvice<Object> {
    private static final String STARTS_WITH_SWAGGER = "springfox.documentation.swagger";

    public NormalResponseAdvice() {
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        Method method = returnType.getMethod();
        return !method.getDeclaringClass().getName().startsWith("springfox.documentation.swagger");
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
        log.info("handle URI:" + request.getURI().toString());
        log.info("handle RequestURI:" + servletRequest.getServletRequest().getRequestURI());
        log.info("handle RequestURL:" + servletRequest.getServletRequest().toString());
        String uri = servletRequest.getServletRequest().getRequestURI();
        if (this.giveUp(uri)) {
            return object;
        } else if (!this.useWrap(request)) {
            return object;
        } else {
            RestResponse result = new RestResponse();
            if (object == null) {
                object = result;
                result.setCode(0);
                result.setMessage("执行成功");
            }

            if (object instanceof RestResponse) {
                result = (RestResponse) object;
            } else if (object instanceof BizException) {
                BizException businessException = (BizException) object;
                result.setCode(500);
                result.setMessage(businessException.getMessage());
            } else {
                result.setCode(0);
                result.setMessage("执行成功");
                result.setData(object);
            }

            log.debug(this.toString(result));
            return result;
        }
    }

    public String toString(Object o) {
        return ReflectionToStringBuilder.toString(o, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public Boolean giveUp(String uri) {
        Set<String> uriSet = new HashSet();
        uriSet.add("/health");
        uriSet.add("/env");
        uriSet.add("/loggers");
        uriSet.add("/metrics");
        uriSet.add("/dump");
        uriSet.add("/auditevents");
        uriSet.add("/trace");
        uriSet.add("/info");
        uriSet.add("/autoconfig");
        uriSet.add("/caches");
        uriSet.add("/mappings");
        return uriSet.contains(uri) || uri.startsWith("/actuator") || uri.contains("/swagger") || uri.startsWith("/v2/api-docs");
    }

    public Boolean useWrap(ServerHttpRequest request) {
        return true;
    }
}
