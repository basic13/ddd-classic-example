package com.qzing.ddd.classic.demo.domain.exchange.trans.service;

import com.qzing.ddd.classic.demo.core.service.DomainService;
import com.qzing.ddd.classic.demo.domain.exchange.account.service.AccountAggService;
import com.qzing.ddd.classic.demo.domain.exchange.account.vo.TransResultVo;
import com.qzing.ddd.classic.demo.domain.exchange.trans.dto.TransDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangyanze
 */
@Component
public class TransDomainService extends DomainService {
    private static AccountAggService accountAggService = aggService(AccountAggService.class);
    private static TransRecordAggService transRecordAggService = aggService(TransRecordAggService.class);

    @Transactional(rollbackFor = Exception.class)
    public TransResultVo trans(TransDto transCmd) {
        TransResultVo transRlt = accountAggService.trans(transCmd);
        transRecordAggService.create(transCmd, transRlt);
        return transRlt;
    }
}
