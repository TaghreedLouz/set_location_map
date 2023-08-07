package com.devtaghreed.map;

import com.google.android.gms.maps.model.LatLng;

public class Item {
    String city;
    LatLng latLng;

    public Item(String city, LatLng latLng) {
        this.city = city;
        this.latLng = latLng;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
