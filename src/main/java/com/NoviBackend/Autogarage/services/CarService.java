package com.NoviBackend.Autogarage.services;

import com.NoviBackend.Autogarage.dto.CarDTO;

import java.util.List;

public interface CarService {
    //Service to create a customer's car
    CarDTO createCar(CarDTO carDTO);

    //Service to get a customer's car by id
    CarDTO getCarById(Long id);

    //Service to get all cars
    List<CarDTO> getAllCars();

    //Service to update a customer's car
    CarDTO updateCar(Long id, CarDTO updatedCar);

    //Service to delete a customer's car
    void deleteCarById(Long id);
}
