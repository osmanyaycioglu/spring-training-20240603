package org.training.spring.springtraining20240603.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { RestrictedWordsImpl.class})
public @interface RestrictedWords {
    String[] value();

    String message() default "{value} kelimeleri bulunamaz.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
