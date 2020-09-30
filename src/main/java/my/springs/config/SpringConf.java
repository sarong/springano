package my.springs.config;


import com.alibaba.druid.pool.DruidDataSource;
import my.springs.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resources;

/*@ComponentScans(@ComponentScan(value = "com.myspring",includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class)
},useDefaultFilters = false))*/

@PropertySource("classpath:/dbconfig.properties")
@ComponentScan(value = "my.springs.dao")
@EnableTransactionManagement
@Configuration
public class SpringConf {

    @Bean("userDao1")
    public UserDao userDao1(){
        return new UserDao("sa1",1);
    }

    @Primary
    @Bean("userDao2")
    public UserDao userDao2(){
        return new UserDao("sa2",2);
    }

    @Value("${db.username}")
    String name;
    @Value("${db.password}")
    String pwd;
    @Value("${db.driverclass}")
    String driver;
    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(name);
        dataSource.setPassword(pwd);
        dataSource.setUrl("jdbc:mysql://localhost:3306/my_data?serverTimezone=UTC");
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

    //配置事务管理器
    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }
}
