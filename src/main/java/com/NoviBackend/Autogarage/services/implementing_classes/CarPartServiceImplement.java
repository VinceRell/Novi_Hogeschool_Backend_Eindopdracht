package com.NoviBackend.Autogarage.services.implementing_classes;

import com.NoviBackend.Autogarage.dto.CarPartDTO;
import com.NoviBackend.Autogarage.exception.ResourceNotFoundException;
import com.NoviBackend.Autogarage.mapper.CarPartMapper;
import com.NoviBackend.Autogarage.models.CarPart;
import com.NoviBackend.Autogarage.repositories.CarPartRepository;
import com.NoviBackend.Autogarage.services.CarPartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarPartServiceImplement implements CarPartService {

    private CarPartRepository carPartRepository;

    @Override  //Method to add a car part
    public CarPartDTO createCarPart(CarPartDTO carPartDTO) {
        CarPart carPart = CarPartMapper.mapToCarPart(carPartDTO);
        CarPart savedCarPart = carPartRepository.save(carPart);
        return CarPartMapper.mapToCarPartDTO(savedCarPart);
    }

    @Override //Method to get a singular car part by id
    public CarPartDTO getCarPartById(Long id) {
        CarPart carPart = carPartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The car part with id:" + id + ", does not exist"));

        return CarPartMapper.mapToCarPartDTO(carPart);
    }

    @Override //Method to get all car parts
    public List<CarPartDTO> getAllCarParts() {
        List<CarPart> carParts = carPartRepository.findAll();
        return carParts.stream().map((carPart) -> CarPartMapper.mapToCarPartDTO(carPart)).collect(Collectors.toList());
    }

    @Override //Method to update a single car part
    public CarPartDTO updateCarPart(Long id, CarPartDTO updatedCarPart) {
        CarPart carPart = carPartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The car part with id:" + id + ", does not exist"));

        carPart.setPartName(updatedCarPart.getPartName());
        carPart.setPrice(updatedCarPart.getPrice());
        carPart.setStock(updatedCarPart.getStock());

        CarPart updatedCarPartOBJ = carPartRepository.save(carPart);

        return CarPartMapper.mapToCarPartDTO(updatedCarPartOBJ);
    }

    @Override //Method to delete a car part
    public void deleteCarPartById(Long id) {
        CarPart carPart = carPartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The car part with id:" + id + ", does not exist"));

        carPartRepository.deleteById(id);
    }
}
