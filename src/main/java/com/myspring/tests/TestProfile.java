package com.myspring.tests;

import com.myspring.beans.Account;
import com.myspring.config.ProfileConf;
import com.myspring.config.SpringConf;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProfile {

    private static void printBeans(ApplicationContext configApplicationContext) {
        String[] beans = configApplicationContext.getBeanDefinitionNames();
        for (String bean : beans)
            System.out.println(bean);
    }

    /*AnnotationConfigApplicationContext的有参构造方法
     * public AnnotationConfigApplicationContext(String... basePackages) {
     *	this();
     *	scan(basePackages);
     *	refresh();
     *}
     * */
    @Test
    public void test1() {
        //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
        //2、代码的方式激活某种环境；
        //创建一个Applicationcontext,无参构造,否则后面的 context.refresh()会报多次refresh的异常
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        //设置需要激活的环境
        context.getEnvironment().setActiveProfiles("Test", "Dev", "Prod");
        //注册主配置类
        context.register(ProfileConf.class);
        //启动刷新容器，refresh之后容器才创建完成
        context.refresh();
        /*AnnotationConfigApplicationContext的有参构造方法
         * public AnnotationConfigApplicationContext(String... basePackages) {
         *	this();
         *	scan(basePackages);
         *	refresh();
         *}
         * 此处相当于手动执行this,scan,和refresh
         * */
        printBeans(context);
    }


}
