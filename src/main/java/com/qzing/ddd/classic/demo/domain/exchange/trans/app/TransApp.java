package com.qzing.ddd.classic.demo.domain.exchange.trans.app;

import com.qzing.ddd.classic.demo.core.bean.Page;
import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.domain.exchange.trans.dto.TransDto;
import com.qzing.ddd.classic.demo.domain.exchange.trans.model.TransRecord;
import com.qzing.ddd.classic.demo.domain.exchange.trans.service.TransDomainService;
import com.qzing.ddd.classic.demo.domain.exchange.trans.service.TransRecordAggService;
import io.ebean.PagedList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangyanze
 */
@RestController
@RequestMapping("/trans")
@Slf4j
public class TransApp extends AppService<TransRecordAggService> {
    private TransDomainService transDomainService = domainService(TransDomainService.class);
    private TransRecordAggService transRecordAggService = aggService();


    @RequestMapping("")
    public Result trans(@RequestBody TransDto dto) {
        return transDomainService.trans(dto);
    }

    @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestBody Page page) {
        return aggService().pageQuery(page);
    }

    @RequestMapping("/pageQuery2")
    public Result pageQuery2(@RequestBody Page page) {
        return Result.success(transRecordAggService.pageQuery2(page), 0);
    }


    @RequestMapping("/test")
    public void test() {
        transRecordAggService.test();
    }
}
