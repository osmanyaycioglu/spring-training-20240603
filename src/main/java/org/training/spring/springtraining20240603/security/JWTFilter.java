package org.training.spring.springtraining20240603.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {
    private JWTService          jwtService;
    private MyUserDetailService detailService;

    public JWTFilter(final JWTService jwtServiceParam,
                     final MyUserDetailService detailServiceParam) {
        jwtService    = jwtServiceParam;
        detailService = detailServiceParam;
    }

    @Override
    protected void doFilterInternal(final HttpServletRequest request,
                                    final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        String authorizationLoc = request.getHeader("Authorization");
        if (authorizationLoc == null || !authorizationLoc.startsWith("Bearer")) {
            filterChain.doFilter(request,
                                 response);
            return;
        }
        String      token     = authorizationLoc.substring(7);
        Jws<Claims> claimsLoc = jwtService.validate(token);
        if (claimsLoc == null) {
            response.setStatus(401);
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            response.getWriter()
                    .println("Token validate edilemedi");
            return;
        }

        Claims      payloadLoc     = claimsLoc.getPayload();
        String      username       = payloadLoc.getSubject();
        UserDetails userDetailsLoc = null;
        try {
            userDetailsLoc = detailService.loadUserByUsername(username);
        } catch (UsernameNotFoundException eParam) {
        }
        if (userDetailsLoc == null) {
            response.setStatus(401);
            response.addHeader("Content-Type",
                               "text/plain;charset=UTF-8");
            response.getWriter()
                    .println("Böyle bir user yok");
            return;
        }
        Authentication authenticateLoc = new UsernamePasswordAuthenticationToken(userDetailsLoc.getUsername(),
                                                                                 userDetailsLoc.getPassword(),
                                                                                 userDetailsLoc.getAuthorities());
        SecurityContextHolder.getContext()
                             .setAuthentication(authenticateLoc);
        filterChain.doFilter(request,
                             response);

    }

}
