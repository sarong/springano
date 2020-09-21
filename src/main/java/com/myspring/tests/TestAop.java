package com.myspring.tests;

import com.myspring.beans.aops.MathCalculator;
import com.myspring.beans.aops.aspects.LogAspects;
import com.myspring.config.AOPConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sun.rmi.runtime.Log;

public class TestAop {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AOPConfig.class);
        MathCalculator mathCalculator = context.getBean("mathCalculator",MathCalculator.class);
        LogAspects logAspects = context.getBean("logAspects", LogAspects.class);
        System.out.println(logAspects.getClass());
        System.out.println(mathCalculator.getClass());
        System.out.println(mathCalculator.div(5,1));
    }

}
