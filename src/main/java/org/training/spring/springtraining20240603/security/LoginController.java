package org.training.spring.springtraining20240603.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/sec")
public class LoginController {
    private final MyUserDetailService    userDetailService;
    private final AuthenticationProvider authenticationProvider;
    private final JWTService             jwtService;

    public LoginController(final MyUserDetailService userDetailServiceParam,
                           AuthenticationProvider authenticationProviderParam,
                           JWTService jwtServiceParam) {
        userDetailService      = userDetailServiceParam;
        authenticationProvider = authenticationProviderParam;
        jwtService             = jwtServiceParam;
    }

    @GetMapping("/login")
    public String method(@RequestParam String user,
                         @RequestParam String pass) {
        Authentication authenticationLoc = new UsernamePasswordAuthenticationToken(user,
                                                                                   pass);
        Authentication authenticateLoc   = authenticationProvider.authenticate(authenticationLoc);
        Collection<? extends GrantedAuthority> authoritiesLoc = authenticateLoc.getAuthorities();

        return jwtService.createToken(user,
                                      "group1");
    }
}
