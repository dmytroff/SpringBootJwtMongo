package rc.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import rc.model.JwtUser;


@Component
public class JwtGenerator {
    public String generate(JwtUser jwtUser) {
        Claims claims= Jwts.claims()
                .setSubject(jwtUser.getUserName());

        claims.put("userId",String.valueOf(jwtUser.getId()));
        claims.put("role",jwtUser.getId());
            return    Jwts.builder()//.setExpiration()
        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, "yugo")
                        .compact();

    }
}
