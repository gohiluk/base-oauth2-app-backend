package com.tnosal.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by gohilukk on 2016-01-26.
 */
public class ServiceDTO {

    private Long id;
    private Long carId;
    private String description;
    private BigDecimal price;
    private BigInteger mileage;
    private Date serviceDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigInteger getMileage() {
        return mileage;
    }

    public void setMileage(BigInteger mileage) {
        this.mileage = mileage;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }
}
