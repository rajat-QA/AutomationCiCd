package com.practice.basics1.pojo;

public class Location {

    private String lat;
    private String lng;

    public Location(String lat, String lng)
    {
        setLat(lat);
        setLng(lng);
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }



}
