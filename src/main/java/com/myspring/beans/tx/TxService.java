package com.myspring.beans.tx;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TxService {
    @Autowired
    TxDao txDao;

    @Transactional
    public void out(){
        txDao.insert();
        System.out.println("插入完成......");
        int i = 10/0;
    }
}
