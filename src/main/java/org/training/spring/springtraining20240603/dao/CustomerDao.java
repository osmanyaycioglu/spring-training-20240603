package org.training.spring.springtraining20240603.dao;

import org.springframework.stereotype.Repository;
import org.training.spring.springtraining20240603.dao.repositories.ICustomerRepository;
import org.training.spring.springtraining20240603.services.models.Customer;
import org.training.spring.springtraining20240603.services.models.Phone;

import java.util.List;

@Repository
public class CustomerDao {
    private final ICustomerRepository customerRepository;

    public CustomerDao(final ICustomerRepository customerRepositoryParam) {
        customerRepository = customerRepositoryParam;
    }

    public void insertCustomer(Customer customerParam){
        customerParam.getAddress().setCustomer(customerParam);
        List<Phone> phonesLoc = customerParam.getPhones();
        for (Phone phoneLoc : phonesLoc) {
            phoneLoc.setCustomer(customerParam);
        }
        customerRepository.save(customerParam);
    }
}
