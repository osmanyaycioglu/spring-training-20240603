package org.training.spring.springtraining20240603.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyUserDetailService implements UserDetailsService {
    private final IUserObjRepository userObjRepository;
    private final BCryptPasswordEncoder cryptPasswordEncoder;

    public MyUserDetailService(final IUserObjRepository userObjRepositoryParam,
                               BCryptPasswordEncoder cryptPasswordEncoderParam) {
        userObjRepository = userObjRepositoryParam;
        cryptPasswordEncoder = cryptPasswordEncoderParam;
        UserObj byUsernameLoc = userObjRepository.findByUsername("xosman");
        if (byUsernameLoc == null){
            UserObj userObjLoc = new UserObj();
            userObjLoc.setMyRole("ADMIN");
            userObjLoc.setUsername("xosman");
            userObjLoc.setPassword("123456");
            userObjRepository.save(userObjLoc);
        }
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        UserObj byUsernameLoc = userObjRepository.findByUsername(username);
        if (byUsernameLoc == null) {
            throw new UsernameNotFoundException("böyle bir user yok");
        }
        return User.builder()
                   .username(username)
                   .password(cryptPasswordEncoder.encode( byUsernameLoc.getPassword()))
                   .authorities(byUsernameLoc.getMyRole())
                   .build();
    }
}
