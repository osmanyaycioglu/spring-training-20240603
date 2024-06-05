package org.training.spring.springtraining20240603.rest;

import org.springframework.web.bind.annotation.*;
import org.training.spring.springtraining20240603.rest.models.CustomerDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {

    @GetMapping("/get/one")
    public CustomerDto getCustomer(@RequestParam String customerId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<CustomerDto> getAllCustomers() {
        return null;
    }

}
