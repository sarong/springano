package com.myspring.beans;

public class Account {
     int id;
     Users user;
     int money;

     public Account(){}

     public Account(int id, Users user, int money){
         this.id = id;
         this.user = user;
         this.money = money;
     }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public int getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userid=" + user.id +
                ",username=" + user.name +
                ", money=" + money +
                '}';
    }
}

