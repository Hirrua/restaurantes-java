package com.hirrua.api_restaurante.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hirrua.api_restaurante.domain.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {

    public String generateToken(CustomerEntity customer) {
        Instant now = Instant.now();
        long expiry = 300L;
        String token;

        try {
            Algorithm algorithm = Algorithm.HMAC256("SECRET");
            return token = JWT.create()
                    .withIssuer("api-restaurante")
                    .withIssuedAt(now)
                    .withSubject(customer.getEmail())
                    .withExpiresAt(now.plusSeconds(expiry))
                    .withClaim("roles", customer.getRole())
                    .sign(algorithm);
        } catch (Exception e) {
            return "Não foi possível gerar o token";
        }
    }

    public String verifyToken(String token) {
        String verifier;
        try {
            Algorithm algorithm = Algorithm.HMAC256("SECRET");
            return verifier = JWT.require(algorithm)
                    .withIssuer("api-restaurant")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (Exception e) {
            return "Não foi possível validar o token";
        }
    }
}
