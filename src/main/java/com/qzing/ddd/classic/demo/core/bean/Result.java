package com.qzing.ddd.classic.demo.core.bean;

import io.ebean.Model;
import io.ebean.PagedList;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.List;

/**
 * @author yangyanze
 */
@Data
public class Result implements Serializable {
    private Boolean success;

    public static Result success() {
        Result rlt = new Result();
        rlt.setSuccess(true);
        return rlt;
    }

    public static Result fail() {
        Result rlt = new Result();
        rlt.setSuccess(false);
        return rlt;
    }

    public static Result success(String message) {
        MessageResult rlt = new MessageResult();
        rlt.setSuccess(true);
        rlt.setMessage(message);
        return rlt;
    }

    public static Result fail(String message) {
        MessageResult rlt = new MessageResult();
        rlt.setSuccess(false);
        rlt.setMessage(message);
        return rlt;
    }

    public static Result fail(Throwable throwable) {
        ExceptionResult rlt = new ExceptionResult();
        rlt.setSuccess(false);
        rlt.setMessage(throwable.getMessage());
        try (StringWriter sw = new StringWriter();
             PrintWriter pw = new PrintWriter(sw);) {
            throwable.printStackTrace(pw);
            rlt.setData(sw.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return rlt;
    }

    public static ModelResult success(Model model) {
        ModelResult rlt = new ModelResult();
        rlt.setSuccess(true);
        rlt.setModel(model);
        return rlt;
    }

    public static PageResult success(List<?> list, Integer total) {
        PageResult rlt = new PageResult();
        rlt.setSuccess(true);
        rlt.setList(list);
        rlt.setTotalCount(total);
        return rlt;
    }


    public static PageResult success(PagedList<?> page) {
        PageResult rlt = new PageResult();
        rlt.setSuccess(true);
        rlt.setList(page.getList());
        rlt.setHasNext(page.hasNext());
        rlt.setHasPrev(page.hasPrev());
        rlt.setTotalCount(page.getTotalCount());
        rlt.setTotalPageCount(page.getTotalPageCount());
        rlt.setPageIndex(page.getPageIndex());
        rlt.setPageSize(page.getPageSize());
        return rlt;
    }

    public static ObjectResult success(Object obj) {
        ObjectResult rlt = new ObjectResult();
        rlt.setSuccess(true);
        rlt.setData(obj);
        return rlt;
    }
}

@Data
@EqualsAndHashCode(callSuper = true)
class MessageResult extends Result {
    private String message;
}

@Data
@EqualsAndHashCode(callSuper = true)
class ExceptionResult extends Result {
    private String message;
    private Object data;
}


@Data
@EqualsAndHashCode(callSuper = true)
class ModelResult extends Result {
    private Model model;
}


@Data
@EqualsAndHashCode(callSuper = true)
class ObjectResult extends Result {
    private Object data;
}

@Data
@EqualsAndHashCode(callSuper = true)
class PageResult extends Result {
    private List<?> list;
    private Integer totalCount;
    private Boolean hasNext;
    private Boolean hasPrev;
    private Integer totalPageCount;
    private Integer pageIndex;
    private Integer pageSize;
}
