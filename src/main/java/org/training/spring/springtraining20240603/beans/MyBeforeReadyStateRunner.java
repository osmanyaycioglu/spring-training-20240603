package org.training.spring.springtraining20240603.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBeforeReadyStateRunner implements ApplicationRunner {

    @Autowired
    @Qualifier("dynamicGreetings")
    private IGreetings greetings;

    @Override
    public void run(final ApplicationArguments args) throws Exception {
        System.out.println("Spring başlıyor");
        greetings.sayHello("osman","yaycıoğlu");
        // throw new IllegalStateException("olmadı baştan");
    }
}
