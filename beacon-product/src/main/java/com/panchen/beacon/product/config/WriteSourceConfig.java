package com.panchen.beacon.product.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = WriteSourceConfig.PACKAGE,
        sqlSessionFactoryRef = "writeSqlSessionFactory")
public class WriteSourceConfig {

    static final String PACKAGE = "com.panchen.beacon.product.mapper.write";
    static final String MAPPER_LOCATION = "classpath:mapper/write/*.xml";

    @Value("${druid.write.datasource.url}")
    private String url;

    @Value("${druid.write.datasource.username}")
    private String user;

    @Value("${druid.write.datasource.password}")
    private String password;

    @Value("${druid.write.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "writeDataSource")
    public DataSource writeSourceConfig() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "writeTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(writeSourceConfig());
    }

    @Bean(name = "writeSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(
            @Qualifier("writeDataSource") DataSource writeDataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(writeDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(WriteSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
