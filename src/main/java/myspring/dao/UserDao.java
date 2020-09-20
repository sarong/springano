package myspring.dao;


import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserDao {
    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
