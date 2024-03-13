package com.vfedotov.rest_api_json_proxy.config;

import com.vfedotov.dao_layer.entity.Account;
import com.vfedotov.rest_api_json_proxy.role.Role;
import com.vfedotov.dao_layer.status.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class SecurityAccount implements UserDetails {

    private String userName;
    private String password;
    private boolean accountNonLocked;
    private Role role;

    public SecurityAccount(String userName, String password, boolean accountNonLocked, Role role) {
        this.userName = userName;
        this.password = password;
        this.accountNonLocked = accountNonLocked;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetails fromAccount(Account account) {
        return new org.springframework.security.core.userdetails.User(
                account.getLogin(), account.getPassword(),
                account.getStatus().equals(Status.ACTIVE),
                account.getStatus().equals(Status.ACTIVE),
                account.getStatus().equals(Status.ACTIVE),
                account.getStatus().equals(Status.ACTIVE),
                account.getRole().getAuthorities()
        );
    }
}
