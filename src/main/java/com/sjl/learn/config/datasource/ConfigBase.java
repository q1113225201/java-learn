package com.sjl.learn.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

@Configuration
@MapperScan(basePackages = "com.sjl.learn.dao.base",
        sqlSessionFactoryRef = "baseSqlSessionFactory")
public class ConfigBase {

    static final String MAPPER_LOCATION = "classpath:mapper/base/*.xml";
    @Value("${base.datasource.url}")
    private String url;
    @Value("${base.datasource.username}")
    private String username;
    @Value("${base.datasource.password}")
    private String password;
    @Value("${base.datasource.driver-class-name}")
    private String driver;

    @Bean(name = "baseDataSource")
    public DataSource baseDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "baseTransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(baseDataSource());
    }

    @Bean(name = "baseSqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("baseDataSource") DataSource baseDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(baseDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ConfigBase.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
