package com.youngtse.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Title: SlaveDbConfig
 * @Date 2023/4/30 13:44
 * @Author Youngtse
 * @Description: TODO
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true,mode = AdviceMode.ASPECTJ)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan(basePackages = "com.youngtse.mapper.slave",sqlSessionFactoryRef = "slaveSqlSessionFactory")
public class SlaveDbConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.slave.datasource")
    public HikariConfig slaveHikariConfig(){
        return new HikariConfig();
    }

    @Bean
    public DataSource slaveDataSource(){
        return new HikariDataSource(slaveHikariConfig());
    }

    @Bean
    public SqlSessionFactory slaveSqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(slaveDataSource());
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath:mapper/slave/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager slavePlatformTransactionManager() {
        return new DataSourceTransactionManager(slaveDataSource());
    }

    @Bean
    public TransactionInterceptor slaveTransactionInterceptor() {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        Properties transactionAttributes = new Properties();
        transactionAttributes.setProperty("*", "PROPAGATION_REQUIRED");
        transactionInterceptor.setTransactionAttributes(transactionAttributes);
        transactionInterceptor.setTransactionManager(slavePlatformTransactionManager());
        return transactionInterceptor;
    }
    @Bean
    public BeanNameAutoProxyCreator slaveBeanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        proxyCreator.setBeanNames("*Handler", "*Service", "*Controller");
        proxyCreator.setInterceptorNames("slaveTransactionInterceptor");
        return proxyCreator;
    }

    @Bean
    public NamedParameterJdbcTemplate slaveNamedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(slaveDataSource());
    }
}
