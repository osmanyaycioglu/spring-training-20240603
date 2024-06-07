package org.training.spring.springtraining20240603.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.KeyStore;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class JWTService {
    private static final Logger logger = LoggerFactory.getLogger(JWTService.class);

    private final Key key;

    public JWTService() {
        key = Keys.hmacShaKeyFor("ksdjghfsdkhjfbdsjahsgdasjkhdbgasjdghasjhdgasjhdgsaksjdgakjdhsgaksjdhakshjdbashjdbajshkdbashdbas".getBytes());
    }

    public String createToken(String username,
                              String group) {
        return Jwts.builder()
                   .subject(username)
                   .issuedAt(new Date())
                   .expiration(Date.from(ZonedDateTime.now()
                                                      .plusHours(1L)
                                                      .toInstant()))
                   .claim("group",
                          group)
                   .signWith(key)
                   .compact();
    }

    public Jws<Claims> validate(String token) {
        JwtParser jwtParserLoc = Jwts.parser()
                                     .setSigningKey(key)
                                     .build();

        try {
            return jwtParserLoc.parseSignedClaims(token);
        } catch (Exception eParam) {
            logger.error("[JWTService][validate]-> *Error* : " + eParam.getMessage(),
                         eParam);
        }
        return null;
    }

}
