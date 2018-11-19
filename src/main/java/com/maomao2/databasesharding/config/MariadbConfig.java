package com.maomao2.databasesharding.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.maomao2.databasesharding.mapper.pkg1", sqlSessionFactoryRef = "mariadbSqlSessionFactory")
public class MariadbConfig {

    @Primary
    @Bean(name = "mariadbDataSource")
    @ConfigurationProperties("mariadb.datasource")
    public DataSource mariadbDataSource() {
        return DataSourceBuilder.create().build();
    }
    @Primary
    @Bean(name = "mariadbSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("mariadbDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mybatis/mapping/pkg1/*.xml"));
        return sessionFactoryBean.getObject();
    }

}
