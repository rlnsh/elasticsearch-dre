package com.hikvision.dre.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryPrimary",
		transactionManagerRef = "transactionManagerPrimary",basePackages = "com.hikvision.dre.domain.repository")
@EntityScan(basePackages = "com.hikvision.dre.domain.entity")
@EnableTransactionManagement(proxyTargetClass = true)
public class PrimaryConfig {
	
	@Resource(name = "primaryDataSource")
	private DataSource primaryDataSource;
	
	@Autowired
	private JpaProperties jpaProperties;
	
	@Bean("entityManagerFactoryPrimary")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary() {
		
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true); // hibernate基本配置
		vendorAdapter.setDatabase(Database.MYSQL);
		vendorAdapter.setShowSql(true);
		
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.hikvision.dre.domain.entity"); // 实体扫描
		factory.setDataSource(primaryDataSource);
		
		Map<String, Object> hibernateProperties = jpaProperties.getHibernateProperties(new HibernateSettings());
		factory.setJpaPropertyMap(hibernateProperties); // 主要目的：读取application.yml的naming-strategy,并设置进去，不然实体属性与表字段之间无法进行驼峰->下划线的自动转换,本来默认就是自动转换的。但是你是配的多个自定义数据源，spring特性之一，一旦自定义，默认不生效，了解一下...<br>
		return factory;
		
	}
	
	@Bean("transactionManagerPrimary")
	@Primary
	public PlatformTransactionManager transactionManagerPrimary() { // 事务管理器：事务不能跨数据源，跨数据源，事务是不生效的。使用事务时，最好要指明使用哪个事务管理器，不然就会默认使用primary修饰的事务管理器
		
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactoryPrimary().getObject());
		return txManager;
		
	}

	@Bean("primaryJdbcTemplate")
	@Primary
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(primaryDataSource);
	}
	
}
