package org.training.spring.springtraining20240603.rest.models;


import jakarta.validation.constraints.NotBlank;

public class AddressDto {
    @NotBlank
    private String city;
    @NotBlank
    private String street;

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
