package com.vfedotov.dao_layer.entity;

import com.vfedotov.dao_layer.role.Role;
import com.vfedotov.dao_layer.status.Status;
import jakarta.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "UserId")
    private Long userId;

    @Column(name = "Role")
    private Role role;

    @Column(name = "Status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Account() {
    }

    public Long getId() {
        return this.id;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public Long getUserId() {
        return this.userId;
    }

    public Role getRole() {
        return this.role;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
