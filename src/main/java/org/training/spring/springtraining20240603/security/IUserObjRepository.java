package org.training.spring.springtraining20240603.security;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserObjRepository extends JpaRepository<UserObj,Long> {
    UserObj findByUsername(String username);
}
