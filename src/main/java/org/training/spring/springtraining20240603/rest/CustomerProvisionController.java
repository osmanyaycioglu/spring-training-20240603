package org.training.spring.springtraining20240603.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.spring.springtraining20240603.rest.models.Customer;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {


    @PostMapping("/add")
    public String add(Customer customerParam){
        return null;
    }

    @GetMapping("/suspend")
    public String suspend(Long customerId){
        return null;
    }

}
