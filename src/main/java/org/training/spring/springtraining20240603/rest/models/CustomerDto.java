package org.training.spring.springtraining20240603.rest.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.training.spring.springtraining20240603.validation.RestrictedWords;

import java.util.List;

public class CustomerDto {
    @NotBlank
    @Size(min = 2,max = 15,message = "2 ile 15 arasında olmalı")
    @RestrictedWords({"abc","xyz","123","234"})
    private String name;
    @NotEmpty
    @Size(min = 3,max = 25)
    private String surname;
    @NotNull
    @Min(10)
    @Max(500)
    private Integer weight;
    @NotNull
    @Min(50)
    @Max(300)
    private Integer height;

    @Valid
    private AddressDto addressDto;

    @Valid
    private List<PhoneDto> phoneDtos;

    public String getName() {
        return name;
    }

    public void setName(final String nameParam) {
        name = nameParam;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surnameParam) {
        surname = surnameParam;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(final Integer weightParam) {
        weight = weightParam;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(final Integer heightParam) {
        height = heightParam;
    }

    public AddressDto getAddress() {
        return addressDto;
    }

    public void setAddress(final AddressDto addressDtoParam) {
        addressDto = addressDtoParam;
    }

    public List<PhoneDto> getPhones() {
        return phoneDtos;
    }

    public void setPhones(final List<PhoneDto> phoneDtoParams) {
        phoneDtos = phoneDtoParams;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", weight=" + weight +
               ", height=" + height +
               '}';
    }
}
