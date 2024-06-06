package org.training.spring.springtraining20240603.jpa;

import jakarta.persistence.*;

@Entity
@Table(name = "PERSON")
public class MyEntity {
    @Id
    @GeneratedValue
    private Long personId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String  name;
    @Column(name = "last_name", nullable = false, length = 50)
    private String  surname;
    @Column(name = "weight")
    private Integer weight;
    private Integer height;


    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(final Long personIdParam) {
        personId = personIdParam;
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
}
