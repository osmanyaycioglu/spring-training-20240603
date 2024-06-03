package org.training.spring.springtraining20240603.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("eng_greet")
@Qualifier("lang_english")
// @Primary
public class GreetingsEng implements IGreetings {
    @Override
    public void sayHello(final String name,
                         final String surname) {
        System.out.println("Hello : " + name + " " + surname );
    }

    @Override
    public void sayGoodbye(final String name,
                           final String surname) {
        System.out.println("Goodbye : " + name + " " + surname );

    }
}
