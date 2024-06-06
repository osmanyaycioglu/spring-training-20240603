package org.training.spring.springtraining20240603.services.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private Long phoneId;
    private String name;
    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customerParam) {
        customer = customerParam;
    }

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
