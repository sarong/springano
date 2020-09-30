package my.springs.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class SqlService {
    @Resource
   SqlDao sqlDao;
    @Transactional
    public void inset(){
        sqlDao.insert();
        System.out.println("插入成功");

    }


}
