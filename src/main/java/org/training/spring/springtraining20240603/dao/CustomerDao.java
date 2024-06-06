package org.training.spring.springtraining20240603.dao;

import org.springframework.stereotype.Repository;
import org.training.spring.springtraining20240603.dao.repositories.ICustomerRepository;
import org.training.spring.springtraining20240603.services.models.Customer;

@Repository
public class CustomerDao {
    private final ICustomerRepository customerRepository;

    public CustomerDao(final ICustomerRepository customerRepositoryParam) {
        customerRepository = customerRepositoryParam;
    }

    public void insertCustomer(Customer customerParam){
        customerRepository.save(customerParam);
    }
}
