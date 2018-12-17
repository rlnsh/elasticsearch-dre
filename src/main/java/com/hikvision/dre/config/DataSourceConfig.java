package com.hikvision.dre.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Auther: wangdingding5
 * @Date: 2018/12/17 14:14
 * @Description: 数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Autowired
    private DataBasePropertiesConfig dataBasePropertiesConfig;

    @Bean(name = "primaryDataSource")
    public DataSource primaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(dataBasePropertiesConfig.getUrl());
        dataSource.setUsername(dataBasePropertiesConfig.getUsername());
        dataSource.setPassword(dataBasePropertiesConfig.getPassword());
//        dataSource.addDataSourceProperty("cachePrepStmts", "true");
//        dataSource.addDataSourceProperty("prepStmtCacheSize", "250");
//        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        return dataSource;
    }

//    @Bean(name = "primaryDataSource", destroyMethod = "close")
//    public DataSource primaryDataSource() {
//        HikariConfig dataSource = new HikariConfig();
//        dataSource.setJdbcUrl(dataBasePropertiesConfig.getUrl());
//        dataSource.setUsername(dataBasePropertiesConfig.getUsername());
//        dataSource.setPassword(dataBasePropertiesConfig.getPassword());
//        dataSource.addDataSourceProperty("cachePrepStmts", "true");
//        dataSource.addDataSourceProperty("prepStmtCacheSize", "250");
//        dataSource.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
//        return new HikariDataSource(dataSource);
//    }
}
