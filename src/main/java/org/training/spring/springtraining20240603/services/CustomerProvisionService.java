package org.training.spring.springtraining20240603.services;

import org.springframework.stereotype.Service;
import org.training.spring.springtraining20240603.services.models.Customer;

@Service
public class CustomerProvisionService {

    public String add(Customer customerParam){
        return "OK";
    }
}
