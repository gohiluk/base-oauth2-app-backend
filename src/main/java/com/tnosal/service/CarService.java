package com.tnosal.service;

import com.tnosal.dao.CarDao;
import com.tnosal.domain.Car;
import com.tnosal.model.CarDTO;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gohilukk on 2016-01-14.
 */
@Service
public class CarService {

    @Autowired
    public CarDao carDao;

    public long saveCar(Car car) {
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
