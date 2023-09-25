package com.example.onlineshop.util;

import com.example.onlineshop.model.TokenPayload;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private String secret = "djfdsbfjkbsdfbkjsdfbsdkfjdsbjfwfefnwijjniwefwfqhfvqwfvqwhvfqhfqkbfwfbhefbwfbewlfwfjwlfw";
    public String generateToken(TokenPayload tokenPayload, long expiredDate){
        Map<String,Object> claims = new HashMap<>();
        claims.put("payload",tokenPayload);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredDate*1000))
                .signWith(getSigningKey(), SignatureAlgorithm.HS512).compact();

    }
    private Key getSigningKey() {
        byte[] keyBytes = this.secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
  //  public <T> T getClaimFromToken()
}
