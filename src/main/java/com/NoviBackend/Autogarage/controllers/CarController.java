package com.NoviBackend.Autogarage.controllers;

import com.NoviBackend.Autogarage.dto.CarDTO;
import com.NoviBackend.Autogarage.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private CarService carService;

    @PostMapping //Adds a customer's car to DB
    public ResponseEntity<CarDTO> createCar(@RequestBody CarDTO carDTO){
        CarDTO savedCar = carService.createCar(carDTO);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }

    @GetMapping("{id}") //Retrieves a single customer's car from DB
    public ResponseEntity<CarDTO> getCarById(@PathVariable("id") Long id){
        CarDTO carDTO = carService.getCarById(id);
        return ResponseEntity.ok(carDTO);
    }

    @GetMapping //Retrieves all cars from DB
    public ResponseEntity<List<CarDTO>> getAllCars(){
        List<CarDTO> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }

    @PutMapping("{id}") //Updates existing car-data stored in DB
    public ResponseEntity<CarDTO> updateCar(@PathVariable("id") Long id, @RequestBody CarDTO updatedCar){
        CarDTO carDTO = carService.updateCar(id, updatedCar);
        return ResponseEntity.ok(carDTO);
    }

    @DeleteMapping("{id}") //Delete a customer's car from the DB
    public ResponseEntity<String> deleteCar(@PathVariable("id") Long id){
        carService.deleteCarById(id);
        return ResponseEntity.ok("Customer's car has been deleted");
    }

}
