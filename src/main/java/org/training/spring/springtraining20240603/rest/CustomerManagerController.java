package org.training.spring.springtraining20240603.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.spring.springtraining20240603.rest.models.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerManagerController {

    @PostMapping("/insert")
    public String insert(Customer customerParam){
        return null;
    }

    @GetMapping("/get")
    public Customer getCustomer(long customerId){
        return null;
    }

}
