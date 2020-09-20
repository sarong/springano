package myspring.tests;

import myspring.beans.Account;
import myspring.config.SpringConf;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAccount {

    private static void printBeans(ApplicationContext configApplicationContext) {
        String[] beans = configApplicationContext.getBeanDefinitionNames();
        for (String bean : beans)
            System.out.println(bean);
    }

    @Test
    public void test1() {
        //xml配置方式
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean1.xml");
        Account account = context.getBean("account", Account.class);

        System.out.println(account);
    }

    @Test
    public void test2() {
        //注解方式
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConf.class);

        System.out.println("IOC容器创建完成");
       /* Account account = context.getBean("acc", Account.class);
        Account account1 = context.getBean("bcc", Account.class);*/
//        System.out.println(account == account1);
        printBeans(context);
       /* System.out.println("account: " + account);
        System.out.println("account1: " + account1);*/
    }

    @Test
    public void test3() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConf.class);
        Object bean1 = context.getBean("colorFacttoryBean");
        Object bean2 = context.getBean("colorFacttoryBean");
        Object bean4 = context.getBean("&colorFacttoryBean");
        System.out.println(bean4.getClass());
        System.out.println(bean1.getClass());
        System.out.println(bean1 == bean2);

        System.out.println(bean1 == bean4);

    }
}
