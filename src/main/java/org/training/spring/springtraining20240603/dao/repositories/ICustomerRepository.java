package org.training.spring.springtraining20240603.dao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.spring.springtraining20240603.services.models.Customer;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
}
