package org.training.spring.springtraining20240603.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.training.spring.springtraining20240603.rest.models.AddressDto;
import org.training.spring.springtraining20240603.rest.models.CustomerDto;
import org.training.spring.springtraining20240603.rest.models.PhoneDto;
import org.training.spring.springtraining20240603.services.models.Address;
import org.training.spring.springtraining20240603.services.models.Customer;
import org.training.spring.springtraining20240603.services.models.Phone;

import java.util.List;

@Mapper
public interface ICustomerMapper {

    ICustomerMapper mapper = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(CustomerDto customer);

    CustomerDto toCustomerDto(Customer customer);

    List<Customer> toCustomers(List<CustomerDto> customer);

    List<CustomerDto> toCustomerDtos(List<Customer> customer);

    Address toAddress(AddressDto address);

    AddressDto toAddressDto(Address address);

    Phone toPhone(PhoneDto phone);

    PhoneDto toPhoneDto(Phone phone);

}
