package com.janz.job_tracker.models;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

@Getter
public class BearerToken extends AbstractAuthenticationToken {

    private final String value;

    public BearerToken(String value) {
        super(AuthorityUtils.NO_AUTHORITIES);
        this.value = value;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

}
