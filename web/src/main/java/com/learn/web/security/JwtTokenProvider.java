package com.learn.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Component
public class JwtTokenProvider {
    private final SecretKey JWT_SECRET; 
    private final long JWT_EXPIRATION = 86400000;   

    public JwtTokenProvider(@Value("${jwt.secret}") String jwtSecret) {
        this.JWT_SECRET = new SecretKeySpec(jwtSecret.getBytes(), 0, jwtSecret.length(), "HmacSHA256");
    }

    public String generateToken(String username) {
        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date expiration = new Date(now + JWT_EXPIRATION);

        return Jwts.builder()
                .subject(username)
                .issuedAt(issuedAt)
                .expiration(expiration)
                .signWith(JWT_SECRET)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser() 
                .verifyWith(JWT_SECRET)
                .build()
                .parseSignedClaims(token); 
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(JWT_SECRET)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }
}
