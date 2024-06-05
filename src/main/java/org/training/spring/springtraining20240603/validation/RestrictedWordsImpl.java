package org.training.spring.springtraining20240603.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RestrictedWordsImpl implements ConstraintValidator<RestrictedWords,String> {
    private RestrictedWords anno;

    @Override
    public void initialize(final RestrictedWords anno) {
        this.anno = anno;
    }

    @Override
    public boolean isValid(final String value,
                           final ConstraintValidatorContext context) {
        String[] valueLoc = anno.value();
        for (String stringLoc : valueLoc) {
            if (value.contains(stringLoc)){
                return false;
            }
        }
        return true;
    }
}
