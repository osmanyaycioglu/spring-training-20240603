package org.training.spring.springtraining20240603.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBeforeReadyStateCommandline implements CommandLineRunner {

    @Autowired
    @Qualifier("dynamicGreetings")
    private IGreetings greetings;


    @Override
    public void run(final String... args) throws Exception {
        System.out.println("Command line runner çağrıldı");
    }
}
