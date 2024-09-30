package com.groupwithprojects.Task_Springboot.utils;


import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);

    }

    private String generateToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 *24 ))
                .signWith(getSignKey(), SignatureAlgorithm.ES256).compact();
    }

    private Key getSignKey(){
        byte[] keyBytes= Decoders.BASE64.decode("Ef2TwUFZLO9jhzlX44o59uDHQH0YrNIRrsR+kolEbLg=");
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
