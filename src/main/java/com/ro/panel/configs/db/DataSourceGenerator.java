package com.ro.panel.configs.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceGenerator {
    @Value("${parameter.db.url}")
    private String paramDbUrl;
    @Value("${parameter.db.name}")
    private String paramDbName;
    @Value("${parameter.db.user}")
    private String paramDbUser;
    @Value("${parameter.db.password}")
    private String paramDbPassword;
    @Value("${parameter.db.driver}")
    private String paramDbDriver;

    private final DataSourceCredentials dataSourceCredentials;
    @Autowired
    public DataSourceGenerator(DataSourceCredentials dataSourceCredentials) {
        this.dataSourceCredentials = dataSourceCredentials;
    }

    @Bean
    public DataSource DataSourceBuilderBean(){
        String dbUrl = dataSourceCredentials.dataSourceCredentials(paramDbUrl);
        String dbName = dataSourceCredentials.dataSourceCredentials(paramDbName);
        String dbUser = dataSourceCredentials.dataSourceCredentials(paramDbUser);
        String dbPass = dataSourceCredentials.dataSourceCredentials(paramDbPassword);
        DataSourceBuilder<?> dataSourceBuilder = org.springframework.boot.jdbc.DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(paramDbDriver);
        dataSourceBuilder.url(dbUrl + dbName);
        dataSourceBuilder.username(dbUser);
        dataSourceBuilder.password(dbPass);
        return dataSourceBuilder.build();
    }

}
