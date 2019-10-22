package com.qzing.ddd.classic.demo.domain.exchange.account.service;

import com.qzing.ddd.classic.demo.core.exception.BizException;
import com.qzing.ddd.classic.demo.core.service.AggService;
import com.qzing.ddd.classic.demo.core.service.EntityService;
import com.qzing.ddd.classic.demo.domain.exchange.account.dto.*;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.Account;
import com.qzing.ddd.classic.demo.domain.exchange.account.vo.TransResultVo;
import com.qzing.ddd.classic.demo.domain.exchange.trans.dto.TransDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author yangyanze
 */
@Service
public class AccountAggService extends AggService {
    private EntityService<Account> entityService = new EntityService<>();


    public Account create(CreateAccountDto cmd) {
        Account account = new Account();
        BeanUtils.copyProperties(cmd, account);
        account.setBalance(BigDecimal.ZERO);
//        account.save();
        entityService.save(account);
        return account;
    }

    public void modify(ModifyAccountDto cmd) {
        Account account = Account.findById(cmd.getGid());
        BeanUtils.copyProperties(cmd, account);
        account.update();
    }

    public void delete(DeleteAccountDto cmd) {
        Account account = Account.findById(cmd.getGid());
        account.delete();
    }

    public void deposit(DepositDto cmd) {
        Account account = Account.findById(cmd.getGid());
        account.increaseBalance(cmd.getAmount()).update();
    }

    public void withdrawal(WithdrawalDto cmd) {
        Account account = Account.findById(cmd.getGid());
        account.deductBalance(cmd.getAmount()).update();
    }

    public TransResultVo trans(TransDto transCmd) {
        TransResultVo rlt = new TransResultVo();
        try {
            Account source = Account.findById(transCmd.getSourceGid());
            Account target = Account.findByNameAndCard(transCmd.getTargetName(), transCmd.getTargetCard());
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
            source.deductBalance(transCmd.getAmount()).update();
            target.increaseBalance(transCmd.getAmount()).update();
            rlt.setSuccess(true);
            return rlt;
        } catch (BizException e) {
            rlt.setSuccess(false);
            rlt.setMessage(e.getMessage());
            return rlt;
        }
    }
}
