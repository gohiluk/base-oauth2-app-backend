package com.tnosal.controller;

import com.tnosal.model.User;
import com.tnosal.response.BaseResponse;
import com.tnosal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gohilukk on 2015-11-11.
 */
@RequestMapping(value = "/api")
@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse registerUser(@RequestBody User user) {

        registerService.setIdsForAuthorityIfExists(user);
        registerService.saveUser(user);

        return new BaseResponse().setSuccessStatus();
    }
}
