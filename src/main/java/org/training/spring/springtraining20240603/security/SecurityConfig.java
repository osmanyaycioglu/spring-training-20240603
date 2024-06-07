package org.training.spring.springtraining20240603.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder cryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public MyUserDetailService myUserDetailService(IUserObjRepository userObjRepositoryParam) {
        return new MyUserDetailService(userObjRepositoryParam,
                                       cryptPasswordEncoder());
    }

    @Bean
    public JWTFilter jwtFilter(JWTService jwtServiceParam,
                               MyUserDetailService myUserDetailServiceParam) {
        return new JWTFilter(jwtServiceParam,
                             myUserDetailServiceParam);
    }

    @Bean
    public SecurityFilterChain confSec(HttpSecurity httpSecurityParam,
                                       JWTFilter jwtFilterParam) throws Exception {
        httpSecurityParam.headers()
                         .frameOptions()
                         .disable();
        return httpSecurityParam.cors(CorsConfigurer::disable)
                                .csrf(CsrfConfigurer::disable)
                                .authorizeHttpRequests(a ->
                                                               a.requestMatchers("/actuator/**",
                                                                                 "/h2-console/**",
                                                                                 "/sec/**")
                                                                .anonymous()
                                                                .requestMatchers("/hello/**")
                                                                .hasAnyAuthority("ADMIN")
                                                                .requestMatchers("/api/v1/customer/query/**")
                                                                .hasAnyAuthority("VIEWER")
                                                                .requestMatchers("/api/**")
                                                                .hasAnyAuthority("ADMIN",
                                                                                 "USER")
                                                                .anyRequest()
                                                                .authenticated()

                                )
                                .addFilterBefore(jwtFilterParam,
                                                 UsernamePasswordAuthenticationFilter.class)
                                .formLogin(FormLoginConfigurer::disable)
                                .httpBasic(HttpBasicConfigurer::disable)
                                .sessionManagement(SessionManagementConfigurer::disable)
                                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(MyUserDetailService myUserDetailServiceParam) {
        DaoAuthenticationProvider providerLoc = new DaoAuthenticationProvider();
        providerLoc.setPasswordEncoder(cryptPasswordEncoder());
        providerLoc.setUserDetailsService(myUserDetailServiceParam);
        return providerLoc;

    }

}
