package com.vfedotov.services_layer.response_dto;

import com.vfedotov.services_layer.request_dto.users.userFields.Address;
import com.vfedotov.services_layer.request_dto.users.userFields.Company;

public class UserDto {
    private long id;
    private String name;
    private String userName;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public UserDto() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public Address getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getWebsite() {
        return this.website;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
