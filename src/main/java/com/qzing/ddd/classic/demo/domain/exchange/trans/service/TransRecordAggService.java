package com.qzing.ddd.classic.demo.domain.exchange.trans.service;

import com.qzing.ddd.classic.demo.core.service.AggService;
import com.qzing.ddd.classic.demo.domain.exchange.account.vo.TransResultVo;
import com.qzing.ddd.classic.demo.domain.exchange.trans.dto.TransDto;
import com.qzing.ddd.classic.demo.domain.exchange.trans.model.TransRecord;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author yangyanze
 */
@Component
public class TransRecordAggService extends AggService {
    public void create(TransDto transCmd, TransResultVo transRlt) {
        TransRecord record = new TransRecord();
        record.setSourceGid(transCmd.getSourceGid());
        record.setAmount(transCmd.getAmount());
        record.setTargetGid(transRlt.getTargetGid());
        record.setRemark(transRlt.getMessage());
        record.setStatus(transRlt.getSuccess() ? TransRecord.TransStaus.SUCCEED : TransRecord.TransStaus.FAILED);
        record.save();
    }
}
