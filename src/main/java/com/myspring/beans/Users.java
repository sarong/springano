package com.myspring.beans;

public class Users {
    int id;
    String name;

    public Users(){}

    public Users(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
