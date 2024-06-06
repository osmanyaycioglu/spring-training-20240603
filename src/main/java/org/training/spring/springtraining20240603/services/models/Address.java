package org.training.spring.springtraining20240603.services.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long addressId;
    private String city;
    private String street;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customerParam) {
        customer = customerParam;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(final Long addressIdParam) {
        addressId = addressIdParam;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String cityParam) {
        city = cityParam;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String streetParam) {
        street = streetParam;
    }
}
