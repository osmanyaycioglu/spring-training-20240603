package org.training.spring.springtraining20240603.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.training.spring.springtraining20240603.services.models.Customer;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findByNameOrderBySurname(String name);

    List<Customer> findByNameAndSurname(String name,String surname);

    List<Customer> findByNameIn(List<String> name);

    @Query("select c from Customer c where c.name=?1")
    List<Customer> searchName(String name);

    @Query(value = "select * from Customer c where c.name=?1",nativeQuery = true)
    List<Customer> searchNameNative(String name);

    @Query("select c.name,c.surname from Customer c where c.name=?1")
    List<Object[]> searchNameAndGetNameSurname(String name);

    @Query("select new org.training.spring.springtraining20240603.dao.repositories.PersonFullName(c.name,c.surname) from Customer c where c.name=?1")
    List<PersonFullName> searchNameAndPersonFullName(String name);

}
