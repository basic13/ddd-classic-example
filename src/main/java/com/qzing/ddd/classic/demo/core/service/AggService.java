package com.qzing.ddd.classic.demo.core.service;

import com.jfinal.template.Engine;
import com.qzing.ddd.classic.demo.core.exception.BizException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author yangyanze
 */
public class AggService extends BaseService {
    @Value("${application.basepackage}")
    private String basePkg;

    private static Engine engine = Engine.use();

    protected String getSql(String key) {
        return getSql(key, null);
    }

    protected String getSql(String key, Map<String, Object> params) {
        String pkg = getClass().getPackage().getName();
        if (!pkg.startsWith(basePkg)) {
            throw new BizException("当前AggService不在配置的基础包" + basePkg + "下，无法获取SQL。" +
                    "请确认application配置中的application.basepackage项是否配置正确。");
        }
        if (pkg.endsWith(".service")) {
            pkg = pkg.replace(".service", "");
        }
        pkg = pkg.replace(basePkg, "").replace(".", "/");

        String path = "sqls" + pkg + "/" + key + ".sql";
        URL sqlFile = Thread.currentThread().getContextClassLoader().getResource(path);
        if (sqlFile == null) {
            throw new BizException("未找到SQL，路径：" + path);
        }
        try {
            String sqlPath = sqlFile.toURI().getPath();
            if (params != null) {
                return engine.getTemplate(sqlPath).renderToString(params);
            } else {
                return FileUtils.readFileToString(new File(sqlPath), StandardCharsets.UTF_8);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            throw new BizException("未能获取到SQL，异常为：" + e.getMessage());
        }
    }
}
