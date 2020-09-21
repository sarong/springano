package com.myspring.beans.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.UUID;

@Repository
public class TxDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public void insert(){
        String sql = "insert into test(name) values(?)";
        String username = UUID.randomUUID().toString().substring(0, 5);
        jdbcTemplate.update(sql,username);
    }
}
