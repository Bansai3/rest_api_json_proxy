package com.vfedotov.services_layer.response_dto;

public class AccountDto {
    private String login;

    private String password;

    private long userId;

    private long id;

    public AccountDto() {
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

    public long getId() {
        return this.id;
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

    public void setId(long id) {
        this.id = id;
    }
}
