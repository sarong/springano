package myspring.config;

import myspring.conditions.MySelector;
import myspring.beans.Account;
import myspring.beans.Color;
import myspring.beans.ColorFacttoryBean;
import myspring.beans.Users;
import myspring.conditions.WindowsCon;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
/*
* 给容器中注册组件：
* 1）包扫描+组件标注注解（@Controller、@Service、@Repository、@Component）自己写的类
* 2）@Bean,导入第三方包里面的组件
* 3）@Import，快速的给容器中导入一个组件
*       a.@Import(要导入的组件)；容器就会自动注册这个组件，id默认是全类名导入多个:@Import{Class1.class,Class2.class}
*       b.@ImportSelector:返回需要导入的组组件全类名数组
*4)使用Spring提供的FactoryBean进行注册:
*       a.获取到的是工场bean调用getObject获取到的对象Color， Object bean1 = context.getBean("colorFacttoryBean");
*       b.要获取到工场对象，需要加上&，获取到的是ColorFacttoryBean
*           Object bean4 = context.getBean("&colorFacttoryBean");
*
*
* */

//基于注解方式的配置类代替xml文件
/*
* @Configuration告诉Spring这是一个配置类
* @ComponentScan配置包扫描路径
* @Bean表示这是一个bean，相当于配置文件中的<bean id=xx......></bean>,此处id默认是类名的小写，比如Account默认id是account，可以通过配置指定id名
*
*
* */

@Configuration
//@ComponentScan(value = "myspring.beans")
@Import({Color.class,myspring.conditions.MySelector.class})//id默认是全类名
@ComponentScans(@ComponentScan(value = "myspring",includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Service.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilter.class)
},useDefaultFilters = false))
/*
*@ComponentScan value:指定要扫描的包
* excludeFilters = Filter[]:指定扫描的时候排除哪些组件
* includeFilters = Filter[]:指定扫描的时候只扫描哪些组件，需要配置useDefaultFilters = false，默认是true，扫描所有包
*   FilterType.ANNOTATION：按照注解
*   FilterType.ASSIGNABLE_TYPE：按照给定的类型；
*   FilterType.ASPECTJ：使用ASPECTJ表达式
*   FilterType.REGEX：使用正则指定
*   FilterType.CUSTOM：使用自定义规则
* */
public class SpringConf {
  /*  @Scope("singleton"),单例的：IOC容器启动会调用方法创建对象放到IOC容器中，以后需要获取该对象时直接去IOC容器(map.get())中拿
                          Account account1 = context.getbean 和Account account2 = context.getbean,获取到的是同一个对象
    @Scope("prototype"),多实例的：IOC容器启动并不会去调用方法将创建对象放在容器中，每次获取的时候才会创建对象
                           此时account1和account2获取到的不再是同一个对象*/
    @Conditional({WindowsCon.class})
    @Scope("singleton")
    @Bean("acc")
    public Account accounto1() {
        System.out.println("accounto1加入到容器中");
        Users users = new Users(2, "Bruce");
        Account account = new Account(2, users, 10);
        return account;
    }

    @Conditional({WindowsCon.class})
    @Bean("bcc")
    public Account account02(){
        System.out.println("accounto2加入到容器中");
        Users users = new Users(3,"Lucky");
        Account account = new Account(3,users,100);
        return account;
    }

    @Bean
    public ColorFacttoryBean colorFacttoryBean(){
        return new ColorFacttoryBean();
    }
}
