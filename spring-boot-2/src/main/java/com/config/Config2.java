package com.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactory", transactionManagerRef = "customerTransactionManager", basePackages = {
		"com.repository" })
public class Config2 {

	Logger logger = LoggerFactory.getLogger(Config2.class);

	@Primary
	@Bean(name = "customerDataSource")
	@ConfigurationProperties(prefix = "sam.read")
	public DataSource customerDataSource() {
		DataSource dataSource = DataSourceBuilder.create().build();
		logger.info("---------------jkkj-------"+dataSource);
		return dataSource;
	}

	@Primary
	@Bean(name = "customerEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("customerDataSource") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.entity").persistenceUnit("db1")
				.build();
	}

	@Primary
	@Bean(name = "customerTransactionManager")
	public PlatformTransactionManager customerTransactionManager(
			@Qualifier("customerEntityManagerFactory") EntityManagerFactory customerEntityManagerFactory) {
		return new JpaTransactionManager(customerEntityManagerFactory);
	}
}
