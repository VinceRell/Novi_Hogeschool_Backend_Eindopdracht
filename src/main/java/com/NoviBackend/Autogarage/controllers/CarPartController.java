package com.NoviBackend.Autogarage.controllers;

import com.NoviBackend.Autogarage.dto.CarPartDTO;
import com.NoviBackend.Autogarage.services.CarPartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/car-parts")
public class CarPartController {

    private CarPartService carPartService;

    @PostMapping //Adds car parts to DB
    public ResponseEntity<CarPartDTO> createCarPart(@RequestBody CarPartDTO carPartDTO){
        CarPartDTO savedCarPart = carPartService.createCarPart(carPartDTO);
        return new ResponseEntity<>(savedCarPart, HttpStatus.CREATED);
    }

    @GetMapping("{id}") //Retrieves a single car part from DB
    public ResponseEntity<CarPartDTO> getCarPartById(@PathVariable("id") Long id){
        CarPartDTO carPartDTO = carPartService.getCarPartById(id);
        return ResponseEntity.ok(carPartDTO);
    }

    @GetMapping //Retrieves all car parts from DB
    public ResponseEntity<List<CarPartDTO>> getAllCarParts(){
        List<CarPartDTO> carParts = carPartService.getAllCarParts();
        return ResponseEntity.ok(carParts);
    }

    @PutMapping("{id}") //Updates existing car parts stored in DB
    public ResponseEntity<CarPartDTO> updateCarPart(@PathVariable("id") Long id, @RequestBody CarPartDTO updatedCarPart){
        CarPartDTO carPartDTO = carPartService.updateCarPart(id, updatedCarPart);
        return ResponseEntity.ok(carPartDTO);
    }

    @DeleteMapping("{id}") //Delete a car part from DB
    public ResponseEntity<String> deleteCarPart(@PathVariable("id") Long id){
        carPartService.deleteCarPartById(id);
        return ResponseEntity.ok("Customer's car has been deleted");
    }
}
