package com.myspring.tests;

import com.myspring.beans.tx.TxService;
import com.myspring.config.TxConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTX {
    @Test
    public void test1(){

        ApplicationContext context =
                new AnnotationConfigApplicationContext(TxConfig.class);
        TxService txService = context.getBean("txService",TxService.class);
        txService.out();
    }
}
