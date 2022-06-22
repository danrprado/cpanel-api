package com.ro.panel.configs.db;

import com.ro.panel.services.aws.ssm.ParameterStoreRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceBuilder {
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

    private final ParameterStoreRetriever parameterStoreRetriever;
    @Autowired
    public DataSourceBuilder(ParameterStoreRetriever parameterStoreRetriever) {
        this.parameterStoreRetriever = parameterStoreRetriever;
    }

    @Bean
    public DataSource dataSourceBuilderGenerator(){
        String dbUrl = parameterStoreRetriever.getParamValue(paramDbUrl);
        String dbName = parameterStoreRetriever.getParamValue(paramDbName);
        String dbUser = parameterStoreRetriever.getParamValue(paramDbUser);
        String dbPass = parameterStoreRetriever.getParamValue(paramDbPassword);
        org.springframework.boot.jdbc.DataSourceBuilder<?> dataSourceBuilder = org.springframework.boot.jdbc.DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(paramDbDriver);
        dataSourceBuilder.url(dbUrl + dbName);
        dataSourceBuilder.username(dbUser);
        dataSourceBuilder.password(dbPass);
        return dataSourceBuilder.build();
    }

}
