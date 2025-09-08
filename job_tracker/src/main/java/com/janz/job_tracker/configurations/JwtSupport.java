package com.janz.job_tracker.configurations;

import com.janz.job_tracker.models.BearerToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtSupport {
    private final SecretKey key = Keys.hmacShaKeyFor(
            "9rSPQFeqLUhTtn9haBaWzPNMKiF6tVxkJhSd8sH7hyk".getBytes(StandardCharsets.UTF_8));
    private final JwtParser parser = Jwts.parser().verifyWith(key).build();

    public BearerToken generateToken(Integer id){
        JwtBuilder builder = Jwts.builder().subject(id.toString())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusSeconds(25200)))
                .signWith(key);
        return new BearerToken(builder.compact());
    }

    public Integer getId(BearerToken token){
        String subject = parser.parseSignedClaims(token.getValue()).getPayload().getSubject();
        return Integer.parseInt(subject);
    }

    public Boolean isTokenExpired(BearerToken token){
        Claims claims = parser.parseSignedClaims(token.getValue()).getPayload();
        return claims.getExpiration().before(Date.from(Instant.now()));
    }
}
