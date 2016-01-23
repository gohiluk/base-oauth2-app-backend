package com.tnosal.controller;

import com.tnosal.domain.Car;
import com.tnosal.domain.User;
import com.tnosal.model.CarDTO;
import com.tnosal.response.BaseResponse;
import com.tnosal.service.CarService;
import com.tnosal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by gohilukk on 2016-01-06.
 */
@RestController
@RequestMapping(value = "/api")
public class CarController {

    @Autowired
    public UserService userService;

    @Autowired
    public CarService carService;

    @RequestMapping(value = "/addCar", method = RequestMethod.POST)
    //public BaseResponse addCar(@RequestBody CarDTO carDTO, OAuth2Authentication auth) {
    public BaseResponse addCar(@RequestParam("name")String name, @RequestParam("picture") MultipartFile picture, OAuth2Authentication auth) throws IOException {

        String username = auth.getUserAuthentication().getName();

        User user = userService.loadUserByUsername(username);

        Car car = new Car();
        car.setName(name);
        car.setPicture(picture.getBytes());
        car.setUser(user);
        carService.saveCar(car);

        return new BaseResponse().setSuccessStatus();
    }

    @RequestMapping(value = "/getCars", method = RequestMethod.GET)
    public List<CarDTO> getCars(OAuth2Authentication auth) {
        String username = auth.getUserAuthentication().getName();
        User user = userService.loadUserByUsername(username);

        List<CarDTO> allByUserId = carService.getAllByUserId(user.getId());

        return allByUserId;
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
    public CarDTO getCar(@PathVariable("id") Long id, OAuth2Authentication auth) {

    }

}
