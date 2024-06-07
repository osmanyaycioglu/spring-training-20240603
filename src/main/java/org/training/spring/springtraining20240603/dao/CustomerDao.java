package org.training.spring.springtraining20240603.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.training.spring.springtraining20240603.dao.repositories.ICustomerRepository;
import org.training.spring.springtraining20240603.jpa.IMyEntityRepository;
import org.training.spring.springtraining20240603.jpa.MyEntity;
import org.training.spring.springtraining20240603.services.models.Customer;
import org.training.spring.springtraining20240603.services.models.Phone;

import java.util.List;
import java.util.Set;

@Repository
public class CustomerDao {
    private final ICustomerRepository customerRepository;
    private final IMyEntityRepository myEntityRepository;

    public CustomerDao(final ICustomerRepository customerRepositoryParam,
                       IMyEntityRepository myEntityRepositoryParam) {
        customerRepository = customerRepositoryParam;
        myEntityRepository = myEntityRepositoryParam;
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_UNCOMMITTED)
    public void insertCustomer(Customer customerParam) { // T1
        customerParam.getAddress()
                     .setCustomer(customerParam);
        Set<Phone> phonesLoc = customerParam.getPhones();
        for (Phone phoneLoc : phonesLoc) {
            phoneLoc.setCustomer(customerParam);
        }
        customerRepository.save(customerParam);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCustomerAndMyEntity(Customer customerParam) { // T1
        insertCustomer(customerParam);
        MyEntity myEntityLoc = new MyEntity();
        myEntityLoc.setName(customerParam.getName());
        myEntityLoc.setSurname(customerParam.getSurname());
        myEntityLoc.setHeight(customerParam.getHeight());
        myEntityLoc.setWeight(customerParam.getWeight());
        myEntityRepository.save(myEntityLoc);
    }

    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                                 .orElse(null);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomersByName(String name) {
        return customerRepository.findByNameOrderBySurname(name);
    }

}
