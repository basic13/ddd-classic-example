package com.qzing.ddd.classic.demo.domain.exchange.trans.service;

import com.qzing.ddd.classic.demo.core.bean.Page;
import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.service.AggService;
import com.qzing.ddd.classic.demo.core.service.EntityService;
import com.qzing.ddd.classic.demo.domain.exchange.account.vo.TransResultVo;
import com.qzing.ddd.classic.demo.domain.exchange.trans.dto.TransDto;
import com.qzing.ddd.classic.demo.domain.exchange.trans.model.TransRecord;
import com.qzing.ddd.classic.demo.domain.exchange.trans.model.query.QTransRecord;
import com.qzing.ddd.classic.demo.domain.exchange.trans.vo.TransRecordVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangyanze
 */
@Component
public class TransRecordAggService extends AggService {
    private EntityService<TransRecord, QTransRecord> transRecordEntityService = EntityService.of(TransRecord.class, QTransRecord.class);
    private final TestDomainService testDomainService;

    public TransRecordAggService(TestDomainService testDomainService) {
        this.testDomainService = testDomainService;
    }

    public void create(TransDto transCmd, TransResultVo transRlt) {
        TransRecord record = new TransRecord();
        record.setSourceGid(transCmd.getSourceGid());
        record.setAmount(transCmd.getAmount());
        record.setTargetGid(transRlt.getTargetGid());
        record.setRemark(transRlt.getMessage());
        record.setStatus(transRlt.getSuccess() ? TransRecord.TransStaus.SUCCEED : TransRecord.TransStaus.FAILED);
        transRecordEntityService.save(record);
    }

    public Result pageQuery(Page page) {
        return transRecordEntityService.pageQuery(page);
    }

    public List<TransRecordVo> pageQuery2(Page page) {
        return null;
    }

    public void test() {
        testDomainService.test();
    }
}
