package com.qzing.ddd.classic.demo.domain.exchange.test.app;

import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.controller.AppController;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.domain.exchange.test.dto.TestDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

/**
 * @author yangyanze
 */
@AppController
@Api(value = "测试用", tags = "Test")
public class TestAutoCtrlAppService extends AppService {
    @ApiOperation(value = "测试1", notes = "测试aaaaaa", httpMethod = "GET")
    public Result test(@RequestBody TestDto dto) {
        return Result.success(dto.getA());
    }

    public Result test2(ServletRequest request) {
        return Result.success(request.getParameter("aaa"));
    }

    @RequestMapping("/test3/{aaa}")
    public Result test3(@PathVariable("aaa") String aaa) {
        return Result.success(aaa);
    }
}
