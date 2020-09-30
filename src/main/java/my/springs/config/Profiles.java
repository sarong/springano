package my.springs.config;


import my.springs.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Profiles {

    @Profile("test")
    @Bean
    public UserDao userDao(){
        UserDao userDao = new UserDao("ss1",1);
        return userDao;
    }

    @Profile("Dev")
    @Bean
    public UserDao userDao1(){
        UserDao userDao = new UserDao("ss2",2);
        return userDao;
    }

}
