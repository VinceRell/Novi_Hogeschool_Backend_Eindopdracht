package com.NoviBackend.Autogarage.mapper;

import com.NoviBackend.Autogarage.dto.CarDTO;
import com.NoviBackend.Autogarage.models.Car;

public class CarMapper {

    public static CarDTO mapToCarDTO(Car car){
        return new CarDTO(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getModelYear());
    }

    public static Car mapToCar(CarDTO carDTO){
        return new Car(
                carDTO.getId(),
                carDTO.getBrand(),
                carDTO.getModel(),
                carDTO.getModelYear());
    }
}
