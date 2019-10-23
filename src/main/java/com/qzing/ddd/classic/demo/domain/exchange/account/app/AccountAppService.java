package com.qzing.ddd.classic.demo.domain.exchange.account.app;

import com.qzing.ddd.classic.demo.core.bean.Page;
import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.domain.exchange.account.dto.*;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.Account;
import com.qzing.ddd.classic.demo.domain.exchange.account.service.AccountAggService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangyanze
 */
@Controller
@RequestMapping("/account")
public class AccountAppService extends AppService<AccountAggService> {
    private AccountAggService aggService = aggService();

    /**
     * 分页查询
     */
    @RequestMapping("/pageQuery")
    @ResponseBody
    public Result pageQuery(@RequestBody Page page) {
        return Result.success(aggService.pageQuery(page));
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @ResponseBody
    public Result save(@RequestBody CreateAccountDto cmd) {
        Account account = aggService.save(cmd);
        return Result.success(account);
    }

    /**
     * 修改
     */
    @RequestMapping("/modify")
    @ResponseBody
    public Result modify(@RequestBody ModifyAccountDto cmd) {
        aggService.modify(cmd);
        return Result.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody DeleteAccountDto cmd) {
        aggService.delete(cmd);
        return Result.success();
    }

    /**
     * 存款
     */
    @RequestMapping("/deposit")
    @ResponseBody
    public Result deposit(@RequestBody DepositDto cmd) {
        aggService.deposit(cmd);
        return Result.success();
    }

    /**
     * 取款
     */
    @RequestMapping("/withdrawal")
    @ResponseBody
    public Result withdrawal(@RequestBody WithdrawalDto cmd) {
        aggService.withdrawal(cmd);
        return Result.success();
    }

}
