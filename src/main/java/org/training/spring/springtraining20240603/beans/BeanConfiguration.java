package org.training.spring.springtraining20240603.beans;

import a.b.c.FuncConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:my.properties")
public class BeanConfiguration {

    @Bean("gr_dyn")
    public IGreetings myGreetings(MyFirstSpringBean firstSpringBeanParam) {
        return new GreetingsEng();
    }

    @Bean
    public IGreetings myGreetings2() {
        return new GreetingsEng();
    }

    @Bean
    public IGreetings dynamicGreetings(Environment environmentParam) {
        return new GreetingsDyn(environmentParam.getProperty("greetings.hello.prefix"),
                                environmentParam.getProperty("greetings.goodbye.prefix"));
    }

    @Bean
    public IGreetings anotherDynamicGreetings(@Value("${greetings.hello.prefix}") String hprefix,
                                              @Value("${greetings.goodbye.prefix}") String gprefix) {
        return new GreetingsDyn(hprefix,
                                gprefix);
    }


}
