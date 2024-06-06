package org.training.spring.springtraining20240603.services.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private Long phoneId;
    private String name;
    private String number;

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(final Long phoneIdParam) {
        phoneId = phoneIdParam;
    }

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
