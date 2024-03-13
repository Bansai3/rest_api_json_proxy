package com.vfedotov.services_layer.request_dto.users.userFields;

public class Geo {
    private double lat;
    private double lng;

    public Geo() {
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
}
