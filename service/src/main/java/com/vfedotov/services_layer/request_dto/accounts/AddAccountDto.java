package com.vfedotov.services_layer.request_dto.accounts;


import com.vfedotov.dao_layer.role.Role;
import com.vfedotov.dao_layer.status.Status;

public class AddAccountDto {
    private String login;
    private String password;
    private long userId;
    private Role role;
    private Status status;

    public AddAccountDto() {
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public long getUserId() {
        return this.userId;
    }

    public Role getRole() {
        return this.role;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
