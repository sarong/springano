package com.myspring.tests;

import com.myspring.config.AutoConfig;
import com.myspring.services.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAutoWired {

    @Test
    public void test1(){

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AutoConfig.class);

        UserService userService = context.getBean("userService",UserService.class);

        userService.printUserDao();
    }

}
