package com.myspring.beans;

public class Car {

    public Car() {
        System.out.println("调用car构造器");
    }

    public void init(){
        System.out.println("init......");
    }

    public void destory(){
        System.out.println("destory......");
    }
}
