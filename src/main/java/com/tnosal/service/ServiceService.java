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

    private static final int FIRST_VALUE_LESSER = -1;

    public void addService(ServiceDTO serviceDTO, Long userId) throws Exception {
        Car car = carDao.getCarByIdAndUserId(serviceDTO.getCarId(), userId);

        if (car != null) {
            com.tnosal.domain.Service service = new com.tnosal.domain.Service();
            service.setDescription(serviceDTO.getDescription());
            service.setMileage(serviceDTO.getMileage());
            service.setServiceDate(serviceDTO.getServiceDate());
            service.setPrice(serviceDTO.getPrice());
            service.setCar(car);

            if (car.getMileage().compareTo(service.getMileage()) == FIRST_VALUE_LESSER) {
                car.setMileage(service.getMileage());
            }

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
            serviceDTO.setId(service.getId());
            serviceDTO.setDescription(service.getDescription());
            serviceDTO.setServiceDate(service.getServiceDate());
            serviceDTO.setMileage(service.getMileage());
            serviceDTO.setPrice(service.getPrice());
            serviceDTOs.add(serviceDTO);
        }
        return serviceDTOs;
    }

    public ServiceDTO getServiceByIdAndCarId(Long id, Long carId, Long userId) {
        //TODO check if user ask for his services
        com.tnosal.domain.Service service = serviceDao.getServiceByIdAndCarId(id, carId);
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(service.getId());
        serviceDTO.setPrice(service.getPrice());
        serviceDTO.setMileage(service.getMileage());
        serviceDTO.setServiceDate(service.getServiceDate());
        serviceDTO.setDescription(service.getDescription());
        serviceDTO.setCarId(carId);
        return serviceDTO;
    }

    public void updateService(ServiceDTO serviceDTO) {
        com.tnosal.domain.Service service = serviceDao.getById(com.tnosal.domain.Service.class, serviceDTO.getId());
        service.setDescription(serviceDTO.getDescription());
        service.setServiceDate(serviceDTO.getServiceDate());
        service.setPrice(serviceDTO.getPrice());
        service.setMileage(serviceDTO.getMileage());

        Car car = service.getCar();

        if (car.getMileage().compareTo(service.getMileage()) == FIRST_VALUE_LESSER) {
            car.setMileage(service.getMileage());
        }

        serviceDao.merge(service);
    }
}
