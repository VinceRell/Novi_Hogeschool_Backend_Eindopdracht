package com.NoviBackend.Autogarage.services.implementing_classes;

import com.NoviBackend.Autogarage.dto.CarDTO;
import com.NoviBackend.Autogarage.exception.ResourceNotFoundException;
import com.NoviBackend.Autogarage.mapper.CarMapper;
import com.NoviBackend.Autogarage.models.Car;
import com.NoviBackend.Autogarage.repositories.CarRepository;
import com.NoviBackend.Autogarage.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarServiceImplement implements CarService {

    private CarRepository carRepository;

    @Override  //Method to add a customer's car
    public CarDTO createCar(CarDTO carDTO) {
        Car car = CarMapper.mapToCar(carDTO);
        Car savedCar = carRepository.save(car);
        return CarMapper.mapToCarDTO(savedCar);
    }

    @Override //Method to get a customer's car by id
    public CarDTO getCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The car with id: " + id + ", does not exist"));

        return CarMapper.mapToCarDTO(car);
    }

    @Override //Method to get all customer's car
    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return  cars.stream().map((car) -> CarMapper.mapToCarDTO(car)).collect(Collectors.toList());
    }

    @Override //Method to update a customer's car
    public CarDTO updateCar(Long id, CarDTO updatedCar) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The car with id:" + id + ", does not exist"));

        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setModelYear(updatedCar.getModelYear());

        Car updatedCarOBJ = carRepository.save(car);

        return CarMapper.mapToCarDTO(updatedCarOBJ);
    }

    @Override //Method to delete a customer's car
    public void deleteCarById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The car with id:" + id + ", does not exist"));

        carRepository.deleteById(id);
    }
}
