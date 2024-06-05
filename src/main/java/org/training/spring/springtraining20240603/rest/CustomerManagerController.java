package org.training.spring.springtraining20240603.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.spring.springtraining20240603.rest.models.CustomerDto;

@RestController
@RequestMapping("/customer")
public class CustomerManagerController {

    @PostMapping("/insert")
    public String insert(CustomerDto customerDtoParam){
        return null;
    }

    @GetMapping("/get")
    public CustomerDto getCustomer(long customerId){
        return null;
    }

}
