package com.malviya.pmp.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author The Rp
 */
@Configuration
@ComponentScan(basePackages = {"com.malviya.contactapp.dao","com.malviya.contactapp.services"})
public class SpringRootConfig {
    @Bean
    public BasicDataSource getDataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/malviya");
        ds.setUsername("root");
        ds.setPassword("roopesh");
        ds.setMaxTotal(1);
        ds.setInitialSize(1);
        ds.setTestOnBorrow(true);
        ds.setValidationQuery("SELECT 1");
        ds.setDefaultAutoCommit(true);
        return ds;         
    }
    
}
