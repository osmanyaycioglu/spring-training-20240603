package org.training.spring.springtraining20240603.services.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.List;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;

    private String  name;
    private String  surname;
    private Integer weight;
    private Integer height;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Phone> phones;


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

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(final Set<Phone> phonesParam) {
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
