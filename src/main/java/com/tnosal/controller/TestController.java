package com.tnosal.controller;

import com.tnosal.dao.CarDao;
import com.tnosal.dao.UserDao;
import com.tnosal.domain.Car;
import com.tnosal.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gohilukk on 2016-01-06.
 */
@RequestMapping(value = "/api")
@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private CarDao carDao;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        Car car = new Car();
        car.setName("opel");
        car.setPicture(new byte[]{1,2,3});

        User byEmail = userDao.findByEmail("admin@aa.pl");

        car.setUser(byEmail);

        carDao.add(car);

        return "ok";
    }
}
