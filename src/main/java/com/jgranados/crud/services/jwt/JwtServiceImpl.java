/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.crud.services.jwt;

import com.jgranados.crud.entities.users.User;
import com.jgranados.crud.enums.users.Role;
import com.jgranados.crud.repositories.UserRepository;
import com.jgranados.crud.services.users.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jose
 */
@Service
public class JwtServiceImpl implements JwtService {
    public static final String SECRET_PHASE = "bmpJGkpYz0Af4ub65tzlnPRX2De1o02uuStUt2y1nhgAXzhngZJtWOgVAlOWYD41";
    
    private UserRepository userRepository;

    @Autowired
    public JwtServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String generateToken(String username) {
        return Jwts.builder()
                .claims(Collections.singletonMap("role", Role.ADMIN))
                .subject(username)
                .expiration(new Date(System.currentTimeMillis() + 900000))
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getSecretKey())
                .compact();
    }

    @Override
    public String getUsername(String token) {
        Claims claims = extractClaims(token);

        return claims.getSubject();
    }

    @Override
    public boolean isValid(String token) {
        Claims claims = extractClaims(token);
        Date expirationDate = claims.getExpiration();

        return new Date().before(expirationDate);
    }

    private Claims extractClaims(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(getSecretKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    private SecretKey getSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_PHASE);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    
    public void updateTokenExpiration(String username) {
        
        Optional<User> userOpt = userRepository.findById(username);
        // TODO validation
        User user = userOpt.get();
        user.setTokenExpiration(LocalDateTime.now().plusMinutes(15));
        userRepository.save(user);
    }
    
    public boolean isTokenExpired(String username) {
        Optional<User> userOpt = userRepository.findById(username);
        // TODO validation
        User user = userOpt.get();
        return user.getTokenExpiration() == null 
                || LocalDateTime.now().isAfter(user.getTokenExpiration());
    }

}
