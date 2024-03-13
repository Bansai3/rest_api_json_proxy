package com.vfedotov.services_layer.request_dto.users;

import com.vfedotov.services_layer.request_dto.users.userFields.Address;
import com.vfedotov.services_layer.request_dto.users.userFields.Company;
import jakarta.validation.constraints.NotEmpty;

public class AddUserDto {
    @NotEmpty(message = "name should not be empty!")
    private String name;

    @NotEmpty(message = "userName should not be empty!")
    private String userName;

    @NotEmpty(message = "email should not be empty!")
    private String email;

    private Address address;

    @NotEmpty(message = "email should not be empty!")
    private String phone;

    @NotEmpty(message = "website should not be empty!")
    private String website;

    private Company company;

    public AddUserDto() {
    }

    public @NotEmpty(message = "name should not be empty!") String getName() {
        return this.name;
    }

    public @NotEmpty(message = "userName should not be empty!") String getUserName() {
        return this.userName;
    }

    public @NotEmpty(message = "email should not be empty!") String getEmail() {
        return this.email;
    }

    public Address getAddress() {
        return this.address;
    }

    public @NotEmpty(message = "email should not be empty!") String getPhone() {
        return this.phone;
    }

    public @NotEmpty(message = "website should not be empty!") String getWebsite() {
        return this.website;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setName(@NotEmpty(message = "name should not be empty!") String name) {
        this.name = name;
    }

    public void setUserName(@NotEmpty(message = "userName should not be empty!") String userName) {
        this.userName = userName;
    }

    public void setEmail(@NotEmpty(message = "email should not be empty!") String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(@NotEmpty(message = "email should not be empty!") String phone) {
        this.phone = phone;
    }

    public void setWebsite(@NotEmpty(message = "website should not be empty!") String website) {
        this.website = website;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
