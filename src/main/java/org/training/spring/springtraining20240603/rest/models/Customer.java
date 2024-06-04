package org.training.spring.springtraining20240603.rest.models;

public class Customer {
    private String name;
    private String surname;
    private int weight;
    private int height;

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

    public int getWeight() {
        return weight;
    }

    public void setWeight(final int weightParam) {
        weight = weightParam;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(final int heightParam) {
        height = heightParam;
    }
}
