package com.tnosal.domain;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

/**
 * Created by gohilukk on 2016-01-24.
 */
@Entity
@Table(name="SERVICE")
@SequenceGenerator(name="ServiceSequence", sequenceName = "SERVICE_SEQ")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ServiceSequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id")
    private Car car;

    private String description;

    private BigInteger price;

    private BigInteger mileage;

    @Column(name = "service_date")
    private Date serviceDate;

    @Lob
    private byte [] picture;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
