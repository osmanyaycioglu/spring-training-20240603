package org.training.spring.springtraining20240603.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.spring.springtraining20240603.rest.models.Customer;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {

    @GetMapping("/get")
    public Customer getCustomer(long customerId){
        return null;
    }


}
