package org.training.spring.springtraining20240603.jpa;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my/entity/test")
public class MyEntityTest {
    private final IMyEntityRepository myEntityRepository;

    public MyEntityTest(final IMyEntityRepository myEntityRepositoryParam) {
        myEntityRepository = myEntityRepositoryParam;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/test1")
    public void test1(@RequestBody MyEntity myEntityParam){
        myEntityRepository.save(myEntityParam);
    }

    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping("/test2")
    public void test2(@RequestBody MyEntity myEntityParam){
        myEntityRepository.save(myEntityParam);
    }

}
