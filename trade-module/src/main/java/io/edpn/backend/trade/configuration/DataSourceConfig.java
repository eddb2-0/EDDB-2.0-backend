package io.edpn.backend.trade.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration("TradeModuleDataSourceConfig")
public class DataSourceConfig {

    @Bean(name = "tradeDataSource")
    public DataSource getDataSource(@Qualifier("tradeDataSourceProperties") DataSourceProperties dataSourceProperties) {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(dataSourceProperties.getDriverClassName());
        dataSourceBuilder.url(dataSourceProperties.getUrl());
        dataSourceBuilder.username(dataSourceProperties.getUsername());
        dataSourceBuilder.password(dataSourceProperties.getPassword());
        return dataSourceBuilder.build();
    }

    @Configuration("TradeModuleDataSourceProperties")
    @ConfigurationProperties(prefix = "trade.spring.datasource")
    @Data
    public static class DataSourceProperties {

        private String url;
        private String username;
        private String password;
        private String driverClassName;

        @Bean(name = "tradeDataSourceProperties")
        public DataSourceProperties dataSourceProperties() {
            return this;
        }
    }
}