package org.training.spring.springtraining20240603.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("lang_turkish")
public class GreetingsTur implements IGreetings {
    @Override
    public void sayHello(final String name,
                         final String surname) {
        System.out.println("Selam : " + name + " " + surname );
    }

    @Override
    public void sayGoodbye(final String name,
                           final String surname) {
        System.out.println("Güle güle : " + name + " " + surname );

    }
}
