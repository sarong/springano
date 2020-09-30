package my.springs.cyclelife;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class CycleTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(CycleConfig.class);

        Environment environment = context.getEnvironment();
        String str = environment.getProperty("os.name");
        System.out.println(str);
        System.out.println("IOC容器创建完成");

        context.close();

    }
}
