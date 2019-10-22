package com.qzing.ddd.classic.demo.domain.exchange.account.model;

import com.qzing.ddd.classic.demo.core.exception.BizException;
import com.qzing.ddd.classic.demo.core.model.BaseModel;
import com.qzing.ddd.classic.demo.domain.exchange.account.model.query.QAccount;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author yangyanze
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "account")
public class Account extends BaseModel {
    /**
     * 用户姓名
     */
    @Column(length = 50)
    private String name;
    /**
     * 余额
     */
    @Column(scale = 2, precision = 65)
    private BigDecimal balance;

    /**
     * 身份证号
     */
    @Column(length = 18)
    private String idcard;
    /**
     * 银行卡号
     */
    @Column(length = 50)
    private String cardno;

    public static Account findById(String gid) {
        Account account = new QAccount().gid.eq(gid).findOne();
        assert account != null;
        return account;
    }

    public static Account findByNameAndCard(String targetName, String targetCard) {
        Account account = new QAccount().name.eq(targetName).cardno.eq(targetCard).findOne();
        return account;
    }

    public Account increaseBalance(BigDecimal amount) {
        setBalance(balance.add(amount));
        return this;
    }

    public Account deductBalance(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new BizException("扣款失败：余额不足");
        }
        setBalance(balance.subtract(amount));
        return this;
    }
}
