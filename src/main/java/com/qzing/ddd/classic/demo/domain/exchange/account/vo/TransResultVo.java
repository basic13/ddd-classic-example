package com.qzing.ddd.classic.demo.domain.exchange.account.vo;

import com.qzing.ddd.classic.demo.core.bean.Result;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author yangyanze
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TransResultVo extends Result {
    private String message;
    private String targetGid;


    public static TransResultVo success(String targetGid) {
        TransResultVo rlt = new TransResultVo();
        rlt.setTargetGid(targetGid);
        rlt.setSuccess(true);
        return rlt;
    }

    public static TransResultVo fail(String message) {
        TransResultVo rlt = new TransResultVo();
        rlt.setMessage(message);
        rlt.setSuccess(false);
        return rlt;
    }

    public static TransResultVo fail(String message, String targetGid) {
        TransResultVo rlt = new TransResultVo();
        rlt.setMessage(message);
        rlt.setTargetGid(targetGid);
        rlt.setSuccess(false);
        return rlt;
    }
}
