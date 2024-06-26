package org.training.spring.springtraining20240603;

import a.b.c.FuncConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.training.spring.springtraining20240603.beans.MySecondSpringBean;

@SpringBootApplication
@Import(FuncConfig.class)
@EnableMethodSecurity(prePostEnabled = true)
//@SpringBootApplication(scanBasePackages = {"org.training.spring.springtraining20240603",
//                                           "a.b.c"
//})
public class SpringTrainingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringTrainingApplication.class,
                                                                          args);
        MySecondSpringBean beanLoc = contextLoc.getBean(MySecondSpringBean.class);
        beanLoc.sayHello("osman");
    }

}
