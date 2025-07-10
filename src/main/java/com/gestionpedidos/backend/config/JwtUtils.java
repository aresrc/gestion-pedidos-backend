package com.gestionpedidos.backend.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Encoders;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtils {
    @Value("${app.jwtSecret}")
    private String jwtSecretBase64;

    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private SecretKey jwtSecretKey;

    @PostConstruct
    public void init() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecretBase64);
        this.jwtSecretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        List<String> roles = user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(jwtSecretKey, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // aquí puedes loggear el error
        }
        return false;
    }
}
