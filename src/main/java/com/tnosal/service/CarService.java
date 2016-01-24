package com.tnosal.service;

import com.tnosal.dao.CarDao;
import com.tnosal.domain.Car;
import com.tnosal.domain.User;
import com.tnosal.model.CarDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gohilukk on 2016-01-14.
 */
@Service
public class CarService {

    @Autowired
    public CarDao carDao;

    public long saveCar(CarDTO carDTO, User user) throws IOException {
        Car car = new Car();
        car.setName(carDTO.getName());
        car.setPicture(carDTO.getPicture().getBytes());
        car.setUser(user);
        return carDao.add(car).getId();
    }

    public List<CarDTO> getAllByUserId(Long id) {
        List<Car> allByUserId = carDao.getAllByUserId(id);
        List<CarDTO> cars = new ArrayList<>();
        for (Car car : allByUserId) {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(car.getId());
            carDTO.setName(car.getName());
            carDTO.setBase64String(convertByteToBase64String(car.getPicture()));
            cars.add(carDTO);
        }
        return cars;
    }

    public CarDTO getCarByIdAndUserId(Long id, Long userId) {
        Car car = carDao.getCarByIdAndUserId(id, userId);
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setName(car.getName());
        carDTO.setBase64String(convertByteToBase64String(car.getPicture()));
        return carDTO;
    }

    public void updateCar(CarDTO carDTO) {
        Car car = carDao.getById(Car.class, carDTO.getId());
        if (carDTO.getName() != null) {
            car.setName(carDTO.getName());
        }

        carDao.merge(car);
    }

    public String convertByteToBase64String(byte[] image) {
        if (image != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("data:image/png;base64,");
            sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(image, false)));
            return sb.toString();
        }
        return "";
    }
}
