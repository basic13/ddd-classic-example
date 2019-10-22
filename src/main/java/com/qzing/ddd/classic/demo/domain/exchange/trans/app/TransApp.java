package com.qzing.ddd.classic.demo.domain.exchange.trans.app;

import com.qzing.ddd.classic.demo.core.bean.Page;
import com.qzing.ddd.classic.demo.core.bean.Result;
import com.qzing.ddd.classic.demo.core.service.AppService;
import com.qzing.ddd.classic.demo.core.service.PublicService;
import com.qzing.ddd.classic.demo.domain.exchange.trans.dto.TransDto;
import com.qzing.ddd.classic.demo.domain.exchange.trans.model.TransRecord;
import com.qzing.ddd.classic.demo.domain.exchange.trans.model.query.QTransRecord;
import com.qzing.ddd.classic.demo.domain.exchange.trans.service.TransDomainService;
import com.qzing.ddd.classic.demo.domain.exchange.trans.service.TransRecordAggService;
import com.qzing.ddd.classic.demo.domain.exchange.trans.vo.TransRecordVo;
import io.ebean.DB;
import io.ebean.DtoQuery;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yangyanze
 */
@Controller
@RequestMapping("/trans")
public class TransApp extends AppService<TransRecord, TransRecordAggService, TransDomainService, PublicService> {
    @RequestMapping("")
    @ResponseBody
    public Result trans(@Validated @RequestBody TransDto dto) {
        return domainService().trans(dto);
    }

    @RequestMapping("/pageQuery")
    @ResponseBody
    public Result pageQuery(@RequestBody Page<TransRecord, QTransRecord> page) {
        return page.query(new QTransRecord());
    }

    @RequestMapping("/pageQuery2")
    @ResponseBody
    public Result pageQuery2(@RequestBody Page<TransRecord, QTransRecord> page) {
        DtoQuery<TransRecordVo> query = DB.findDto(TransRecordVo.class,
                "select t.*,a1.name as source_name,a1.cardno as source_card,a2.name as target_name,a2.cardno as target_card " +
                        "from trans_record t " +
                        "left join account a1 on t.source_gid=a1.gid " +
                        "left join account a2 on t.target_gid=a2.gid " +
                        "where a1.name =:name or a2.name=:name");
        query.setParameter("name", "张三");
        query.setMaxRows(page.getSize());
        query.setFirstRow(page.getSize() * page.getPage());
        List<TransRecordVo> list = query.findList();
        return Result.success(list, 0);


    }
}
