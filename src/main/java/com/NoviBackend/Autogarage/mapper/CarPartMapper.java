package com.NoviBackend.Autogarage.mapper;

import com.NoviBackend.Autogarage.dto.CarPartDTO;
import com.NoviBackend.Autogarage.models.CarPart;


public class CarPartMapper {

    public static CarPartDTO mapToCarPartDTO(CarPart carPart) {
        return new CarPartDTO(
                carPart.getId(),
                carPart.getPartName(),
                carPart.getPrice(),
                carPart.getStock());
    }

    public static CarPart mapToCarPart(CarPartDTO carPartDTO) {
        return new CarPart(
                carPartDTO.getId(),
                carPartDTO.getPartName(),
                carPartDTO.getPrice(),
                carPartDTO.getStock());
    }
}
