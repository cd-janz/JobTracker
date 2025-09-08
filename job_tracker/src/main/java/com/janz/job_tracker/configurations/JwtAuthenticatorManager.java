package com.janz.job_tracker.configurations;


import com.janz.job_tracker.models.BearerToken;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Component
public class JwtAuthenticatorManager implements ReactiveAuthenticationManager {
    private final JwtSupport _jwt;

    public JwtAuthenticatorManager(JwtSupport jwt) {
        _jwt = jwt;
    }


    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return null;
    }

    private Authentication validateToke(BearerToken token){
        Integer id = _jwt.getId(token);
        if(id == null) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token");
        if(_jwt.isTokenExpired(token)) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token expired");
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(id, null, authorities);
    }

}
