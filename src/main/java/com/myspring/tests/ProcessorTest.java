package com.myspring.tests;


import com.myspring.config.ProcessorConfig;
import com.myspring.processor.MyBeanPro;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 
public class ProcessorTest {
    @Test
    public void test1(){

        ApplicationContext context =
                new AnnotationConfigApplicationContext(ProcessorConfig.class);

    }

}
