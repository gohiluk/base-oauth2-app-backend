package com.tnosal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by gohilukk on 2015-11-11.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    private @Value("${db.driver}") String dbDriver;
    private @Value("${db.password}") String dbPassword;
    private @Value("${db.url}") String dbUrl;
    private @Value("${db.username}") String dbUsername;


    private @Value("${hibernate.dialect}") String HIBERNATE_DIALECT;
    private @Value("${hibernate.show_sql}") String HIBERNATE_SHOW_SQL;
    private @Value("${hibernate.hbm2ddl.auto}") String HIBERNATE_HBM2DDL_AUTO;
    private @Value("${entitymanager.packagesToScan}") String ENTITYMANAGER_PACKAGES_TO_SCAN;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(dbUrl, dbUsername, dbPassword);
        dataSource.setDriverClassName(dbDriver);
        return dataSource;
    }

    @Bean(name = "sessionFactory")
    public org.springframework.orm.hibernate4.LocalSessionFactoryBean sessionFactory() {
        org.springframework.orm.hibernate4.LocalSessionFactoryBean localSessionFactoryBean = new org.springframework.orm.hibernate4.LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
        hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
        hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
        localSessionFactoryBean.setHibernateProperties(hibernateProperties);
        return localSessionFactoryBean;
    }

    @Bean
    @Primary
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

}