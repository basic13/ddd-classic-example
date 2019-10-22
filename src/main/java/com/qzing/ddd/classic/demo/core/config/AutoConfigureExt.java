package com.qzing.ddd.classic.demo.core.config;

import io.ebean.config.AutoConfigure;
import io.ebean.config.IdGenerator;
import io.ebean.config.ServerConfig;
import io.ebean.spring.txn.SpringJdbcTransactionManager;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.UUID;

/**
 * @author yangyanze
 */
public class AutoConfigureExt implements AutoConfigure {
    public AutoConfigureExt() {
    }

    @Override
    public void preConfigure(ServerConfig serverConfig) {
        //设置DataSource
        DataSource dataSource = BeanFactoryProvider.getBean(DataSource.class);
        if (dataSource != null) {
            serverConfig.setDataSource(dataSource);
        }
        serverConfig.setExternalTransactionManager(new SpringJdbcTransactionManager());
        serverConfig.setCurrentUserProvider(() -> "系统用户");
        serverConfig.setIdGenerators(Collections.singletonList(new IdGenerator() {
            @Override
            public Object nextValue() {
                return UUID.randomUUID().toString().replace("-", "");
            }

            @Override
            public String getName() {
                return "UUID";
            }
        }));
    }

    @Override
    public void postConfigure(ServerConfig serverConfig) {

    }
}
