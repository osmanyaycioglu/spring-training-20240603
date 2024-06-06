package org.training.spring.springtraining20240603.services.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;

    private String name;
    private String surname;
    private Integer weight;
    private Integer height;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(final Long customerIdParam) {
        customerId = customerIdParam;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address addressParam) {
        address = addressParam;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(final List<Phone> phonesParam) {
        phones = phonesParam;
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
