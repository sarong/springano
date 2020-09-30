package my.springs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

/*
 * @Resource(name=" ")
 * @Autowired + @Qualifier
 * @Inject + @Qualifier
 *
 * */
@Service
public class UserService {

//    @Inject

    @Resource(name = "userDao1")
    UserDao userDao;

    public UserService() {
        System.out.println("UserService constructor......");
    }

    public void printUserDao() {
        System.out.println(userDao);
    }
}
