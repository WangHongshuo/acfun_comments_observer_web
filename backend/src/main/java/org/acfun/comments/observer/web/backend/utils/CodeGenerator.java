package org.acfun.comments.observer.web.backend.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.querys.PostgreSqlQuery;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
        private static final String outputDir = System.getProperty("user.dir") + "/backend/src/main/java";
        private static final String mapperXmlDir = System.getProperty("user.dir")
                        + "/backend/src/main/resources/mapper";

        public static void main(String[] args) {
                generator("jdbc:postgresql://localhost:5432/acfun_comm", "acfuncomm", "postgres", "1",
                                Arrays.asList("comment", "article"));
                generator("jdbc:postgresql://localhost:5432/acfun_comm_web", "acfuncommweb",
                                "postgres", "1", Arrays.asList("account"));
        }

        public static void generator(String dbUrl, String dbName, String dbUserName, String dbPassword,
                        List<String> tableNames) {
                DataSourceConfig.Builder dataSourceConfig = new DataSourceConfig.Builder(
                                dbUrl, dbUserName, dbPassword).dbQuery(new PostgreSqlQuery());
                FastAutoGenerator.create(dataSourceConfig)
                                .globalConfig(builder -> {
                                        builder.author("Wang Hongshuo")
                                                        .outputDir(outputDir);
                                })
                                .packageConfig(builder -> {
                                        builder.parent("org.acfun.comments.observer.web")
                                                        .moduleName("backend")
                                                        .pathInfo(Collections.singletonMap(OutputFile.xml,
                                                                        mapperXmlDir));
                                })
                                .strategyConfig(builder -> {
                                        builder.addInclude(tableNames).entityBuilder().enableLombok()
                                                        .enableFileOverride()
                                                        .controllerBuilder().enableRestStyle()
                                                        .mapperBuilder().enableBaseResultMap().enableBaseColumnList()
                                                        .enableFileOverride()
                                                        .serviceBuilder();
                                })
                                .templateEngine(new FreemarkerTemplateEngine())
                                .execute();
        }
}
