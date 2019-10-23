package com.qzing.ddd.classic.demo.domain.exchange.account.service;

import com.qzing.ddd.classic.demo.core.bean.Page;
import com.qzing.ddd.classic.demo.core.exception.BizException;
import com.qzing.ddd.classic.demo.core.service.AggService;
import com.qzing.ddd.classic.demo.core.service.EntityService;
import com.qzing.ddd.classic.demo.domain.exchange.account.dto.*;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.Account;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.query.QAccount;
import com.qzing.ddd.classic.demo.domain.exchange.account.vo.TransResultVo;
import com.qzing.ddd.classic.demo.domain.exchange.trans.dto.TransDto;
import io.ebean.PagedList;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author yangyanze
 */
@Service
public class AccountAggService extends AggService {
    private EntityService<Account, QAccount> accountEntityService = EntityService.of(Account.class, QAccount.class);


    /**
     * 增加余额
     */
    private void increaseBalance(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
    }

    /**
     * 扣减余额
     */
    private void deductBalance(Account account, BigDecimal amount) {
        if (account.getBalance().compareTo(amount) < 0) {
            throw new BizException("扣款失败：余额不足");
        }
        account.setBalance(account.getBalance().subtract(amount));
    }

    /**
     * 分页查询
     */
    public PagedList<Account> pageQuery(Page page) {
        return accountEntityService.pageQuery(page);
    }

    /**
     * 保存
     */
    public Account save(CreateAccountDto cmd) {
        Account account = new Account();
        BeanUtils.copyProperties(cmd, account);
        account.setBalance(BigDecimal.ZERO);
        accountEntityService.save(account);
        return account;
    }

    /**
     * 修改
     */
    public void modify(ModifyAccountDto cmd) {
        Account account = accountEntityService.findById(cmd.getGid());
        BeanUtils.copyProperties(cmd, account);
        accountEntityService.update(account);
    }

    /**
     * 删除
     */
    public void delete(DeleteAccountDto cmd) {
        Account account = accountEntityService.findById(cmd.getGid());
        accountEntityService.delete(account);
    }


    /**
     * 存款
     */
    public void deposit(DepositDto cmd) {
        Account account = accountEntityService.findById(cmd.getGid());
        increaseBalance(account, cmd.getAmount());
        account.update();
    }

    /**
     * 取款
     */
    public void withdrawal(WithdrawalDto cmd) {
        Account account = accountEntityService.findById(cmd.getGid());
        deductBalance(account, cmd.getAmount());
        account.update();
    }

    /**
     * 通过姓名和卡号查询
     */
    public Account findByNameAndCard(String name, String card) {
        return accountEntityService.getQuery()
                .name.eq(name)
                .cardno.eq(card)
                .findOne();
    }

    /**
     * 转账
     */
    public TransResultVo trans(TransDto transCmd) {
        TransResultVo rlt = new TransResultVo();
        try {
            Account source = accountEntityService.findById(transCmd.getSourceGid());
            Account target = findByNameAndCard(transCmd.getTargetName(), transCmd.getTargetCard());

            if (target == null) {
                rlt.setMessage("转账目标账户名+用户不存在");
                rlt.setSuccess(false);
                return rlt;
            }
            if (target.getGid().equals(source.getGid())) {
                rlt.setMessage("不能给自己转账");
                rlt.setSuccess(false);
                return rlt;
            }
            rlt.setTargetGid(target.getGid());
            deductBalance(source, transCmd.getAmount());
            increaseBalance(target, transCmd.getAmount());
            source.update();
            target.update();
            rlt.setSuccess(true);
            return rlt;
        } catch (BizException e) {
            rlt.setSuccess(false);
            rlt.setMessage(e.getMessage());
            return rlt;
        }
    }

}
