package com.qzing.ddd.classic.demo.domain.exchange.test.app;

import com.qzing.ddd.classic.demo.core.controller.AppController;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.domain.exchange.test.dto.TestDto2;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 二次开发
 */
@AppController(value = "auto-ctrl", priority = 1)
public class SecondAutoCtrlAppService extends AppService {
    /**
     * 覆盖原有Controller方法，参数和返回值全变
     *
     * @param dto
     * @return
     */
    public TestDto2 test(@RequestBody TestDto2 dto) {
        return dto;
    }
}
