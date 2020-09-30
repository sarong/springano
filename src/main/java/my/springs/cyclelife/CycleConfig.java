package my.springs.cyclelife;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan(value = "my.springs.cyclelife.processors")
@Configuration
public class CycleConfig {
    @Bean(initMethod = "init", destroyMethod = "destory")
    public CycleDao cycleDao(){
        return new CycleDao();
    }
}
