package org.training.spring.springtraining20240603.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
// @Service
// @Configuration
// @Controller
// @Repository
@Lazy
// @Scope("prototype")
public class MyFirstSpringBean {
    private String value;
    private int counter = 0;

    public void myMethod(String stringParam){
        counter++;
        System.out.println("Hello : " + stringParam + " counter : " + counter);
    }

}
