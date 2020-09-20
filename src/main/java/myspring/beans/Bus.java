package myspring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Bus implements InitializingBean, DisposableBean {

    public Bus(){
        System.out.println("Bus构造器......");
    }

    public void destroy() throws Exception {
        System.out.println("destroyBean......");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet......");
    }
}
