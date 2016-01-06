package com.tnosal.controller;

import com.tnosal.model.CarDTO;
import com.tnosal.response.BaseResponse;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gohilukk on 2016-01-06.
 */
@RestController
@RequestMapping(name = "/api")
public class CarController {

    @RequestMapping(name = "/addCar", method = RequestMethod.POST)
    public BaseResponse addCar(@RequestBody CarDTO carDTO, OAuth2Authentication auth) {



        return new BaseResponse().setSuccessStatus();
    }
}
