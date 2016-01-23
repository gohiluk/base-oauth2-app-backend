package com.tnosal.controller;

import com.tnosal.binder.UserBinder;
import com.tnosal.domain.User;
import com.tnosal.model.UserDTO;
import com.tnosal.response.BaseResponse;
import com.tnosal.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gohilukk on 2015-11-11.
 */
@RestController
@RequestMapping(value = "/api")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BaseResponse registerUser(@RequestBody UserDTO userDTO) {
        User user = UserBinder.bindUser(userDTO, passwordEncoder);

        registerService.setUserRole(user);
        registerService.saveUser(user);

        return new BaseResponse().setSuccessStatus();
    }
}
