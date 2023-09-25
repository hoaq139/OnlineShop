package com.example.onlineshop.util;

import com.example.onlineshop.model.TokenPayload;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {
    private String secret = "Hoaq_13";
    public String generateToken(TokenPayload tokenPayload, long expiredDate){
        Map<String,Object> claims = new HashMap<>();
        claims.put("payload",tokenPayload);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredDate*1000))
                .signWith(SignatureAlgorithm.HS256,secret).compact();

    }
  //  public <T> T getClaimFromToken()
}
