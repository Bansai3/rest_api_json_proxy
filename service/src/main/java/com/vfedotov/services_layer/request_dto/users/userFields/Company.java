package com.vfedotov.services_layer.request_dto.users.userFields;

public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company() {
    }

    public String getName() {
        return this.name;
    }

    public String getCatchPhrase() {
        return this.catchPhrase;
    }

    public String getBs() {
        return this.bs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
