package org.training.spring.springtraining20240603.dao.repositories;

public class PersonFullName {
    private String firstName;
    private String lastName;

    public PersonFullName(final String firstNameParam,
                          final String lastNameParam) {
        firstName = firstNameParam;
        lastName  = lastNameParam;
    }

    public PersonFullName() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstNameParam) {
        firstName = firstNameParam;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastNameParam) {
        lastName = lastNameParam;
    }
}
