package com.tnosal.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by gohilukk on 2016-01-06.
 */
@Entity
@Table(name="CAR")
@SequenceGenerator(name="CarSequence", sequenceName = "CAR_SEQ")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CarSequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    private String name;

    @Lob
    private byte [] picture;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "car")
    private Set<Service> services;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
