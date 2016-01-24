package com.tnosal.response;

/**
 * Created by gohilukk on 2015-12-13.
 */
public class BaseResponse {

    private static final String STATUS_SUCCESS = "success";

    private String status;

    private Long id;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseResponse setSuccessStatus() {
        this.status = STATUS_SUCCESS;
        return this;
    }

    public BaseResponse setCreatedObjectId(Long id) {
        this.id = id;
        return this;
    }
}
