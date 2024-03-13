package com.vfedotov.services_layer.request_dto.users.userFields;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    public Address() {
    }

    public String getStreet() {
        return this.street;
    }

    public String getSuite() {
        return this.suite;
    }

    public String getCity() {
        return this.city;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public Geo getGeo() {
        return this.geo;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
