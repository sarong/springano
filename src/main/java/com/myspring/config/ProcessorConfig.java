package com.myspring.config;

import com.myspring.beans.Bus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/*
 *BeanFactoryPostProcessor（实例初始化之前执行）:beanFactory的后置处理器，
 *       在BeanFactory标准初始化之后调用，来定制和修改BeanFactory的内容；
 *       所有Bean的定义已经加载到beanFactory，但是bean实例还未初始化
 *执行时机：
 *      1）、ioc创建对象
 * 		2）、refresh()-》invokeBeanFactoryPostProcessors(beanFactory);
 * 		3）、从容器中获取到所有的BeanDefinitionRegistryPostProcessor组件。
 * 			1、依次触发所有的postProcessBeanDefinitionRegistry()方法
 * 			2、再来触发postProcessBeanFactory()方法BeanFactoryPostProcessor；
 * 		4）、再来从容器中找到BeanFactoryPostProcessor组件；然后依次触发postProcessBeanFactory()方法
 *
 * BeanDefinitionRegistryPostProcessor，在Bean定义将要加载到beanFactory时执行，所以执行在BeanFactoryPostProcessor之前
 *
 *
 * */
@ComponentScan("com.myspring.processor")
@Configuration
public class ProcessorConfig {
    @Bean
    public Bus bus() {
        return new Bus();
    }
}
