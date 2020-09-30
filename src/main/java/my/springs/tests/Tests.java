package my.springs.tests;

import my.springs.config.Profiles;
import my.springs.config.SpringConf;
import my.springs.dao.SqlService;
import my.springs.dao.UserDao;
import my.springs.dao.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.applet.Applet;
import java.util.Map;
import java.util.SortedMap;

public class Tests {
    public static void print(ApplicationContext context){
        String[] beans = context.getBeanDefinitionNames();
        for(String bean:beans)
            System.out.println(bean);
    }

    @Test
    public void test1(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConf.class);
        UserService userService = context.getBean("userService",UserService.class);
        userService.printUserDao();
    }

    @Test
    public void testProfile(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("Dev","test");
        context.register(Profiles.class);
        context.refresh();
        print(context);
        UserDao userDao = context.getBean("userDao",UserDao.class);

        System.out.println(userDao);
    }

    @Test
    public void testSql(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConf.class);
        SqlService sqlService = context.getBean("sqlService",SqlService.class);
        sqlService.inset();
    }

}

