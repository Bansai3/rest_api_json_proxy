package com.vfedotov.dao_layer.role;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

public enum Role {

    ADMIN("ROLE_ADMIN"),
    POSTS_ADMIN("ROLE_POSTS"),
    USERS_ADMIN("ROLE_USERS"),
    ALBUMS_ADMIN("ROLE_ALBUMS");


    private String role;

    Role(String role) {
        this.role = role;
    }
    public Set<SimpleGrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority(role));
    }
}
