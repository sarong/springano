package com.myspring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/*
 * Profile:
 *      Spring提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 *      例如:开发环境、测试环境的切换；
 *      数据源的切换
 *@Profile:指定组件在哪个环境的情况下才能被注册到容器中，不指定的情况下，默认都能注册
 * 1) 加了环境标识的Bean，只有这个环境被激活时才能注册到容器中，默认时default环境
 * 2) @Profile写在配置类上时，只有时指定环境的时候配置类才生效
 * 3)没有@Profile标识的Bean在所有指定的环境下都是加载的
 * */
@PropertySource("classpath:/dbconfig.properties")
@Profile("Test")
@Configuration
public class ProfileConf implements EmbeddedValueResolverAware {

    @Value("${db.username}")
    private String name;

    private StringValueResolver valueResolver;
    private String driver;

    @Value("${db.password}")
    private String pwd;

    @Profile("Test")
    @Bean
    public DataSource dataSourceTest() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(name);
        dataSource.setPassword(pwd);
        dataSource.setUrl("jdbc:mysql://localhost:3306/my_data?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC");
        dataSource.setDriverClassName(driver);
        return dataSource;

    }

    @Profile("Dev")
    @Bean("DevDataSource")
    public DataSource dataSourceDev() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(name);
        dataSource.setPassword(pwd);
        dataSource.setUrl("jdbc:mysql://localhost:3306/mmybatis?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC");
        dataSource.setDriverClassName(driver);
        return dataSource;

    }

    @Profile("Prod")
    @Bean("ProdDataSource")
    public DataSource dataSourceProd() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(name);
        dataSource.setPassword(pwd);
        dataSource.setUrl("jdbc:mysql://localhost:3306/device_management?useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC");
        dataSource.setDriverClassName(driver);
        return dataSource;

    }


    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = resolver;
        driver = valueResolver.resolveStringValue("${db.driverclass}");
    }
}
