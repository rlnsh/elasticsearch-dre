package com.hikvision.dre.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
        return dataSource;
    }

}
