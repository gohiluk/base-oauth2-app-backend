package com.tnosal.response;

/**
 * Created by gohilukk on 2015-12-13.
 */
public class BaseResponse {

    private static final String STATUS_SUCCESS = "success";

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BaseResponse setSuccessStatus() {
        this.status = STATUS_SUCCESS;
        return this;
    }
}
