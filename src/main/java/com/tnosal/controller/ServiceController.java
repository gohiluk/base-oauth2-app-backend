package com.tnosal.controller;

import com.tnosal.model.ServiceDTO;
import com.tnosal.model.UserDetails;
import com.tnosal.response.BaseResponse;
import com.tnosal.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by gohilukk on 2016-01-26.
 */
@RestController
@RequestMapping(value = "/api")
public class ServiceController {

    @Autowired
    public ServiceService serviceService;

    @RequestMapping(value = "/service", method = RequestMethod.GET)
    public List<ServiceDTO> getServices(@RequestParam(value = "carId", required = true) String carId, OAuth2Authentication auth) {
        Long userId = ((UserDetails)auth.getUserAuthentication().getPrincipal()).getId();
        List<ServiceDTO> allByCarId = serviceService.getAllByCarId(Long.parseLong(carId), userId);

        return allByCarId;
    }

    @RequestMapping(value = "/service", method = RequestMethod.POST)
    public BaseResponse addService(@RequestBody ServiceDTO serviceDTO, OAuth2Authentication auth) throws Exception {

        Long userId = ((UserDetails)auth.getUserAuthentication().getPrincipal()).getId();

        serviceService.addService(serviceDTO, userId);

        return new BaseResponse().setSuccessStatus();
    }
}
