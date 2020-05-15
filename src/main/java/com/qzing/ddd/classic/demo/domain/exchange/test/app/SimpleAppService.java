package com.qzing.ddd.classic.demo.domain.exchange.test.app;

import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.controller.AppController;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.domain.exchange.test.dto.TestDto;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yangyanze
 */
@AppController
public class SimpleAppService extends AppService {
    public Result foo(@RequestBody TestDto bar) {
        return Result.success();
    }
}
