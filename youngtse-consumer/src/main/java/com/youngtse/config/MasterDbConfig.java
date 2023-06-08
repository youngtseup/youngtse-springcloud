package com.youngtse.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
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
 * @Title: MasterDbConfig
 * @Date 2023/4/30 13:39
 * @Author Youngtse
 * @Description: TODO
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true,mode = AdviceMode.PROXY)
@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan(basePackages = "com.youngtse.mapper.master",sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDbConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.master.datasource")
    @Qualifier("masterHikariConfig")
    public HikariConfig masterHikariConfig(){
        return new HikariConfig();
    }

    @Bean
    @Primary
    @Qualifier("masterDataSource")
    public DataSource masterDataSource(@Qualifier("masterHikariConfig") HikariConfig hikariConfig){

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resourcePatternResolver.getResources("classpath:mapper/master/*Mapper.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    @Qualifier("masterPlatformTransactionManager")
    public PlatformTransactionManager masterPlatformTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public TransactionInterceptor masterTransactionInterceptor(@Qualifier("masterPlatformTransactionManager")
                                                                       PlatformTransactionManager platformTransactionManager) {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        Properties transactionAttributes = new Properties();
        transactionAttributes.setProperty("*", "PROPAGATION_REQUIRED");
        transactionInterceptor.setTransactionAttributes(transactionAttributes);
        transactionInterceptor.setTransactionManager(platformTransactionManager);
        return transactionInterceptor;
    }

    @Bean
    public BeanNameAutoProxyCreator masterBeanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator proxyCreator = new BeanNameAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        proxyCreator.setBeanNames("*Handler", "*Service", "*Controller");
        proxyCreator.setInterceptorNames("masterTransactionInterceptor");
        return proxyCreator;
    }

    @Bean
    public NamedParameterJdbcTemplate masterNamedParameterJdbcTemplate(@Qualifier("masterDataSource") DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
