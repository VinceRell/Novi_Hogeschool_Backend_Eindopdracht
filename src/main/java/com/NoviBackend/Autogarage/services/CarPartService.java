package com.NoviBackend.Autogarage.services;

import com.NoviBackend.Autogarage.dto.CarPartDTO;

import java.util.List;

public interface CarPartService {
    //Service to create a car part
    CarPartDTO createCarPart(CarPartDTO carPartDTO);

    //Service to get a car part by id
    CarPartDTO getCarPartById(Long id);

    //Service to get all car parts
    List<CarPartDTO> getAllCarParts();

    //Service to update car parts
    CarPartDTO updateCarPart(Long id, CarPartDTO updatedCarPart);

    //Service to delete a car part
    void deleteCarPartById(Long id);
}
