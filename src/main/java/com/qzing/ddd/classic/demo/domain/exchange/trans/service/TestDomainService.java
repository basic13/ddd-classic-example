package com.qzing.ddd.classic.demo.domain.exchange.trans.service;

import com.qzing.ddd.classic.demo.core.service.DomainService;
import org.springframework.stereotype.Component;

/**
 * @author yangyanze
 */
@Component
public class TestDomainService extends DomainService {
    public void test() {
        System.out.println("testing");
    }
}
