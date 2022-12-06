package com.example.tokenauthenticate.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
@AllArgsConstructor
@Builder

public class JwtTokenUtil {

    public static String createToken(String userName, String key, Long expireTimeMs){
        Claims claims = Jwts.claims();
        claims.put("userNAme", userName);

     return Jwts.builder()
             .setClaims(claims)
             .setIssuedAt(new Date(System.currentTimeMillis()))
             .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
             .signWith(SignatureAlgorithm.HS256, key)
             .compact();
    }


}
