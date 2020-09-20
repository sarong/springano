package myspring.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Motor {

    public Motor(){

        System.out.println("Moto constuctor....");
    }

    @PostConstruct
    public void initP(){
        System.out.println("PostConstruct......");
    }

    @PreDestroy
    public void destoryP(){
        System.out.println("PreDestory");
    }


}
