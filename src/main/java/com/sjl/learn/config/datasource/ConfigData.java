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

@Configuration
@MapperScan(basePackages = "com.sjl.learn.dao.data",
        sqlSessionFactoryRef = "dataSqlSessionFactory")
public class ConfigData {
    static final String MAPPER_LOCATION = "classpath:mapper/data/*.xml";
    @Value("${data.datasource.url}")
    private String url;
    @Value("${data.datasource.username}")
    private String username;
    @Value("${data.datasource.password}")
    private String password;
    @Value("${data.datasource.driver-class-name}")
    private String driver;

    @Bean(name = "dataDataSource")
    @Primary
    public DataSource dataDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "dataTransactionManager")
    @Primary
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(dataDataSource());
    }

    @Bean(name = "dataSqlSessionFactory")
    @Primary
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("dataDataSource") DataSource dataDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ConfigData.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
