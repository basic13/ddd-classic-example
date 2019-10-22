package com.qzing.ddd.classic.demo.domain.exchange.account.app;

import com.qzing.ddd.classic.demo.core.bean.Page;
import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.core.service.DomainService;
import com.qzing.ddd.classic.demo.core.service.PublicService;
import com.qzing.ddd.classic.demo.domain.exchange.account.dto.*;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.Account;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.query.QAccount;
import com.qzing.ddd.classic.demo.domain.exchange.account.service.AccountAggService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangyanze
 */
@Controller
@RequestMapping("/account")
public class AccountAppService extends AppService<Account, AccountAggService, DomainService, PublicService> {
    @RequestMapping("/pageQuery")
    @ResponseBody
    public Result pageQuery(@RequestBody Page<Account, QAccount> page) {
        return page.query(new QAccount());
    }

    @RequestMapping("/save")
    @ResponseBody
    public Result save(@RequestBody @Validated CreateAccountDto cmd) {
        Account account = aggService().create(cmd);
        return Result.success(account);
    }

    @RequestMapping("/modify")
    @ResponseBody
    public Result modify(@RequestBody @Validated ModifyAccountDto cmd) {
        aggService().modify(cmd);
        return Result.success();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody @Validated DeleteAccountDto cmd) {
        aggService().delete(cmd);
        return Result.success();
    }

    @RequestMapping("/deposit")
    @ResponseBody
    public Result deposit(@RequestBody @Validated DepositDto cmd) {
        aggService().deposit(cmd);
        return Result.success();
    }

    @RequestMapping("/withdrawal")
    @ResponseBody
    public Result withdrawal(@RequestBody @Validated WithdrawalDto cmd) {
        aggService().withdrawal(cmd);
        return Result.success();
    }

}
