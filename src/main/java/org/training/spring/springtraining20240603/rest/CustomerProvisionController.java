package org.training.spring.springtraining20240603.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training.spring.springtraining20240603.rest.error.ErrorObj;
import org.training.spring.springtraining20240603.rest.mappers.ICustomerMapper;
import org.training.spring.springtraining20240603.rest.models.CustomerDto;
import org.training.spring.springtraining20240603.services.CustomerProvisionService;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {
    private CustomerProvisionService customerProvisionService;

    public CustomerProvisionController(final CustomerProvisionService customerProvisionServiceParam) {
        customerProvisionService = customerProvisionServiceParam;
    }

    @PostMapping("/add")
    public String add(@RequestBody @Valid CustomerDto customerDtoParam) {
        return customerProvisionService.add(ICustomerMapper.mapper.toCustomer(customerDtoParam));
    }

    @GetMapping("/suspend")
    public String suspend(@RequestParam String customerId) {
        return null;
    }



}
