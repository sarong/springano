package com.myspring.tests;

import com.myspring.beans.Persion;
import com.myspring.config.ValueConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestValue {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ValueConfig.class);
        Persion persion = context.getBean("persion",Persion.class);
        System.out.println(persion);
    }


}
