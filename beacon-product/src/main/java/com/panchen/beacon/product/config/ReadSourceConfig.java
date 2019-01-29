package com.panchen.beacon.product.config;

import javax.sql.DataSource;
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
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = ReadSourceConfig.PACKAGE, sqlSessionFactoryRef = "readSqlSessionFactory")
public class ReadSourceConfig {

    static final String PACKAGE = "com.panchen.beacon.product.mapper.read";
    static final String MAPPER_LOCATION = "classpath:mapper/read/*.xml";

    @Value("${druid.read.datasource.url}")
    private String url;

    @Value("${druid.read.datasource.username}")
    private String user;

    @Value("${druid.read.datasource.password}")
    private String password;

    @Value("${druid.read.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "readDataSource")
    @Primary
    public DataSource readSourceConfig() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "readTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(readSourceConfig());
    }

    @Bean(name = "readSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(
            @Qualifier("readDataSource") DataSource readDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(readDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ReadSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
