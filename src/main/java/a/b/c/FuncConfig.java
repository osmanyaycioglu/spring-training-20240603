package a.b.c;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FuncConfig {

    @Bean
    public OutterBean outterBean(){
        return new OutterBean();
    }
}


