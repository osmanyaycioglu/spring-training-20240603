package org.training.spring.springtraining20240603.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IMyEntityRepository extends JpaRepository<MyEntity,Long> {
}
