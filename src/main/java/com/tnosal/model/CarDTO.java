package com.tnosal.model;

/**
 * Created by gohilukk on 2016-01-06.
 */
public class CarDTO {

    private String name;
    private byte [] picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
