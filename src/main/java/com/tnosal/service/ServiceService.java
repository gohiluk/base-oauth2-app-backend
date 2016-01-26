package com.tnosal.service;

import com.tnosal.dao.CarDao;
import com.tnosal.dao.ServiceDao;
import com.tnosal.domain.Car;
import com.tnosal.model.ServiceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gohilukk on 2016-01-26.
 */
@Service
public class ServiceService {

    @Autowired
    public ServiceDao serviceDao;

    @Autowired
    public CarDao carDao;

    public void addService(ServiceDTO serviceDTO, Long userId) throws Exception {
        Car car = carDao.getCarByIdAndUserId(serviceDTO.getCarId(), userId);

        if (car != null) {
            com.tnosal.domain.Service service = new com.tnosal.domain.Service();
            service.setDescription(serviceDTO.getDescription());
            service.setMileage(serviceDTO.getMileage());
            service.setServiceDate(serviceDTO.getServiceDate());
            service.setPrice(serviceDTO.getPrice());
            service.setCar(car);

            serviceDao.add(service);
        } else {
            throw new Exception("Not you car");
        }
    }

    public List<ServiceDTO> getAllByCarId(Long carId, Long userId) {
        //TODO check if user ask for his services
        List<com.tnosal.domain.Service> allByCarId = serviceDao.getAllByCarId(carId);
        List<ServiceDTO> serviceDTOs = new ArrayList<>();
        for (com.tnosal.domain.Service service : allByCarId) {
            ServiceDTO serviceDTO = new ServiceDTO();
            serviceDTO.setDescription(service.getDescription());
            serviceDTO.setServiceDate(service.getServiceDate());
            serviceDTO.setMileage(service.getMileage());
            serviceDTO.setPrice(service.getPrice());
            serviceDTOs.add(serviceDTO);
        }
        return serviceDTOs;
    }
}
