package org.training.spring.springtraining20240603.services;

import org.springframework.stereotype.Service;
import org.training.spring.springtraining20240603.dao.CustomerDao;
import org.training.spring.springtraining20240603.services.models.Customer;

import java.util.List;

@Service
public class CustomerQueryService {
    private final CustomerDao customerDao;

    public CustomerQueryService(final CustomerDao customerDaoParam) {
        customerDao = customerDaoParam;
    }
    public Customer getCustomer(Long customerId) {
        return customerDao.getCustomer(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public List<Customer> getCustomersByName(String name) {
        return customerDao.getCustomersByName(name);
    }

}
