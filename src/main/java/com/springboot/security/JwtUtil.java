package com.springboot.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // 10 horas
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Llave secreta

    // Generar token con un solo rol
    public String generateToken(String username, String rol) {
        return Jwts.builder()
                .setSubject(username)
                .claim("rol", rol)  // Claim rol (String)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(secretKey)
                .compact();
    }

    // Obtener username del token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Obtener rol del token como String
    public String extractRol(String token) {
        return (String) extractClaims(token).get("rol");
    }

    // Obtener roles como lista (para el filtro), aquí solo un rol
    public List<String> extractRoles(String token) {
        String rol = extractRol(token);
        return rol != null ? Collections.singletonList(rol) : Collections.emptyList();
    }

    // Validar token (firma válida, no expirado)
    public boolean isTokenValid(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // ExpiredJwtException, MalformedJwtException, SignatureException, etc.
            return false;
        }
    }

    // Extraer claims del token
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
    