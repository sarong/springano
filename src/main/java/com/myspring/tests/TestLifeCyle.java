package com.myspring.tests;

import com.myspring.config.ConfigOfLife;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestLifeCyle {
    @Test
    public void test1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigOfLife.class);
//        System.out.println("IOC容器创建完成======");
//        Car car = context.getBean("car",Car.class);
//        Bus bus = context.getBean(Bus.class);

//        Motor motor = context.getBean(Motor.class);
//        car.destory();
        context.close();
    }

}
