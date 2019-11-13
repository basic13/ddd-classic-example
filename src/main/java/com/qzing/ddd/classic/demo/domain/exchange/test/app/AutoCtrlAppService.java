package com.qzing.ddd.classic.demo.domain.exchange.test.app;

import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.controller.AppController;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.domain.exchange.test.dto.TestDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author yangyanze
 */
@AppController
public class AutoCtrlAppService extends AppService {
    public Result test(@RequestBody TestDto dto) {
        return Result.success(dto.getA() + " ddd");
    }

    public Result test2(ServletRequest request) {
        return Result.success(request.getParameter("aaa"));
    }

    @RequestMapping("/test3/{aaa}")
    public Result test3(@PathVariable("aaa") String aaa) {
        return Result.success(aaa);
    }

    public Result async(@RequestBody TestDto dto) {
        exec(() -> {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(dto);
        });
        System.out.println("程序已返回");
        return Result.success("执行成功");
    }
}
