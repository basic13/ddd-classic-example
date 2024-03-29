package com.qzing.ddd.classic.demo.core.migration;

import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;

import java.io.IOException;

public class GenerateDbMigration {
    public static void main(String[] args) throws IOException {

        DbMigration dbMigration = DbMigration.create();
        dbMigration.setPlatform(Platform.MYSQL);

        String sop = dbMigration.generateMigration();
        System.out.println(sop);
    }

}
