package com.myspring.config;

import com.myspring.beans.Persion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
* 属性赋值的三种方式：
*   1)@Value(" ")
*   2)@Valus("#{表达式}")
*   3)@Value("${配置文件中的变量名}")，需要将配置文件配置在@Configuration类中
* */
@PropertySource("classpath:/persion.properties")
@Configuration
public class ValueConfig {

    @Bean
    public Persion persion(){
        return new Persion();
    }
}
