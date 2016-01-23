package com.tnosal.model;

/**
 * Created by gohilukk on 2016-01-06.
 */
public class CarDTO {

    private Long id;
    private String name;
    private String base64String;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase64String() {
        return base64String;
    }

    public void setBase64String(String base64String) {
        this.base64String = base64String;
    }
}
