package myspring.config;

import myspring.beans.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/*
* Bean生命周期：
*   bean创建-初始化-销毁的过程
* 容器管理bean的生命周期；
* 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候，调用我们自定义的初始化和销毁方法
* 对象创建（构造）：
*         单实例：容器启动的时候创建对象
*         多实例：每次获取的时候创建对象
*
* BeanPostProcessor.postProcessBeforeInitialization()
*
* 初始化:
*       对象创建完成，并赋值好，调用初始化方法，所以单例模式实在创建容器的时候就调用初始化方法，而多例IOC容器创建完毕时并不会调用初始化方法，getBean获取时才会调用
*
* BeanPostProcessor.postProcessAfterInitialization()
*
* 销毁:
*       单实例Bean是在IOC容器关闭时销毁(context.close();)
*       多实例Bean，容器不会管理这个bean，不会调用销毁方法，需要手动执行销毁(car.destory();)
*
* 1)指定初始化和销毁方法： xml方式：指定init-method和destory-method
*                      注解方式，@Bean(initMethod = "init",destroyMethod = "destory"),指定初始化方法和销毁方法名
* 2)通过让Bean实现InitializingBean定义初始化，实现DisposableBean定义销毁
* 3)使用jsr250:
*       @PostConstruct: bean创建完成并赋值之后执行的方法
*       @PreDestroy: bean销毁之前执行的方法
* 4)BeanPostProcessor接口:bean的后置处理器，在bean初始化前后进行一些处理工作
*                       postProcessBeforeInitialization:在初始化之前工作
*                       postProcessAfterInitialization:在初始化之后工作
*
*
* */
@ComponentScan(value = "myspring.beans")
@Configuration

public class ConfigOfLife {

    @Bean(initMethod = "init",destroyMethod = "destory")
    public Car car(){
        return new Car();
    }
}
