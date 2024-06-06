package org.training.spring.springtraining20240603.rest;

import org.springframework.web.bind.annotation.*;
import org.training.spring.springtraining20240603.rest.mappers.ICustomerMapper;
import org.training.spring.springtraining20240603.rest.models.CustomerDto;
import org.training.spring.springtraining20240603.services.CustomerQueryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {
    private final CustomerQueryService customerQueryService;

    public CustomerQueryController(final CustomerQueryService customerQueryServiceParam) {
        customerQueryService = customerQueryServiceParam;
    }

    @GetMapping("/get/one")
    public CustomerDto getCustomer(@RequestParam Long customerId) {
        return ICustomerMapper.mapper.toCustomerDto(customerQueryService.getCustomer(customerId));
    }

    @GetMapping("/get/all")
    public List<CustomerDto> getAllCustomers() {
        return ICustomerMapper.mapper.toCustomerDtos(customerQueryService.getAllCustomers());
    }

    @GetMapping("/get/by/name")
    public List<CustomerDto> getCustomersByName(@RequestParam String name) {
        return ICustomerMapper.mapper.toCustomerDtos(customerQueryService.getCustomersByName(name));
    }

}
