package org.training.spring.springtraining20240603.services;

import org.springframework.stereotype.Service;
import org.training.spring.springtraining20240603.dao.CustomerDao;
import org.training.spring.springtraining20240603.services.models.Customer;

@Service
public class CustomerProvisionService {
    private final CustomerDao customerDao;

    public CustomerProvisionService(final CustomerDao customerDaoParam) {
        customerDao = customerDaoParam;
    }

    public String add(Customer customerParam){
        customerDao.insertCustomer(customerParam);
        return "Customer created : " + customerParam.getCustomerId();
    }
}
