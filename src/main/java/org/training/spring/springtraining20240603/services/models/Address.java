package org.training.spring.springtraining20240603.services.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long addressId;
    private String city;
    private String street;


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
