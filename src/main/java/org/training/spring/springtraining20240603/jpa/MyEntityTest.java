package org.training.spring.springtraining20240603.jpa;

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

    @PostMapping
    public void method(@RequestBody MyEntity myEntityParam){
        myEntityRepository.save(myEntityParam);
    }

}
