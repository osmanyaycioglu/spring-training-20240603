package org.training.spring.springtraining20240603.beans;

import org.springframework.stereotype.Component;

@Component
public class MyFirstSpringBean {
    private String value;

    public void myMethod(String stringParam){
        System.out.println("Hello : " + stringParam);
    }

}
