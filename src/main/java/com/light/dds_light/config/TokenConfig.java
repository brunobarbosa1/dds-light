package com.light.dds_light.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.light.dds_light.entities.User;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.Optional;

@Component
public class TokenConfig {

//    @Value("${dds.security.secret}")
    private String secret = "secret";

    public String generateToken(User user) {

        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId", user.getId())
                .withClaim("nome", user.getNome())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API para gerenciamento de DDS's da Light")
                .sign(algorithm);
    }

    public Optional<JWTUserData> validateToken(String token) {

        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(new JWTUserData(
                    decodedJWT.getClaim("userId").asLong(),
                    decodedJWT.getSubject()
            ));
        }catch (JWTVerificationException e){
            return Optional.empty();
        }
    }
}
