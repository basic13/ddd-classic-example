//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.qzing.ddd.classic.demo.core.controller.response;

import com.qzing.ddd.classic.demo.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@ControllerAdvice
@Slf4j
public class ExceptionResponseHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResponseHandler.class);
    @Value("${debug:false}")
    private Boolean debug;

    public ExceptionResponseHandler() {
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleInvalidRequestError(MethodArgumentNotValidException ex) {
        log.error("", ex);
        List<ObjectError> errorList = ex.getBindingResult().getAllErrors();
        StringBuilder msg = new StringBuilder();
        for (ObjectError error : errorList) {
            msg.append(";").append(error.getDefaultMessage());
        }

        return new ErrorResponse(1001, msg.toString().replaceFirst(";", ""));
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleInvalidRequestError(MethodArgumentTypeMismatchException ex) {
        log.error("", ex);
        return new ErrorResponse(1001, "参数类型异常");
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error("", ex);
        return this.debug ? new ErrorResponse(1002, ex.toString()) : new ErrorResponse(1002, "输入的请求参数有误,请核实后重新输入");
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleHttpMessageNotReadableException(IllegalArgumentException ex) {
        log.error("", ex);
        return new ErrorResponse(1002, ex.getMessage());
    }

    @ExceptionHandler({BizException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleBusinessException(BizException ex) {
        log.error("", ex);
        return new ErrorResponse(1003, ex.getMessage());
    }


    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUnexpectedServerError(Exception ex) {
        log.error("", ex);
        return new ErrorResponse(1000, ex.getMessage());
    }

    @ExceptionHandler({HttpServerErrorException.class})
    @ResponseBody
    public ErrorResponse handleHttpServerErrorException(HttpServerErrorException ex, HttpServletResponse response) {
        response.setStatus(ex.getStatusCode().value());
        log.error("", ex);
        log.error(ex.getResponseBodyAsString());
        return new ErrorResponse(ex.getStatusCode().value(), ex.getMessage());
    }

    @ExceptionHandler({MaxUploadSizeExceededException.class})
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ResponseBody
    public ErrorResponse handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, HttpServletResponse response) {
        log.error("", ex);
        return new ErrorResponse(1000, "文件大小超过系统限制");
    }
}
