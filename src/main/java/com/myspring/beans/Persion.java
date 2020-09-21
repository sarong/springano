package com.myspring.beans;

import org.springframework.beans.factory.annotation.Value;

public class Persion {
    @Value("saro")
    String name;
    @Value("${persion.email}")
    String email;
    @Value("#{22-2}")
    int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
