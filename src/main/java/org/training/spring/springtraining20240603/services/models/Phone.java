package org.training.spring.springtraining20240603.services.models;

import jakarta.validation.constraints.NotBlank;

public class Phone {
    private String name;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(final String nameParam) {
        name = nameParam;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String numberParam) {
        number = numberParam;
    }
}
