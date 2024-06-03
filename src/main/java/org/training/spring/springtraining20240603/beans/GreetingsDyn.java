package org.training.spring.springtraining20240603.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class GreetingsDyn implements IGreetings {
    private String helloPrefix;
    private String goodbyePrefix;

    public GreetingsDyn(final String helloPrefixParam,
                        final String goodbyePrefixParam) {
        helloPrefix   = helloPrefixParam;
        goodbyePrefix = goodbyePrefixParam;
    }

    @Override
    public void sayHello(final String name,
                         final String surname) {
        System.out.println(helloPrefix + " : " + name + " " + surname );
    }

    @Override
    public void sayGoodbye(final String name,
                           final String surname) {
        System.out.println(goodbyePrefix + " : " + name + " " + surname );

    }
}
