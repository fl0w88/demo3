package com.example.demo3.controller;

import com.example.demo3.car.Car;
import com.example.demo3.car.CarFactory;
import com.example.demo3.car.CarOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @PostMapping(value = "/orders", consumes = "application/json", produces = "application/json")
    public ResponseEntity orderCar(@RequestBody CarOrder carOrder) {
        try {
            Car orderedCar = CarFactory.buildCar(carOrder.getManufacturer(), carOrder.getModel(), carOrder.getColor());
            return ResponseEntity.ok(orderedCar);
        } catch (InvalidPropertiesFormatException e) {
            if (e.getMessage().equals("color")) {
                return new ResponseEntity<>("{\"error\": \"Invalid color\"}", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("{\"error\": \"Invalid manufacturer\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/available-colors", produces = "application/json")
    public ResponseEntity getColors() {
        return ResponseEntity.ok(CarFactory.getAvailableColors());
    }

    @GetMapping(value = "/available-manufacturers", produces = "application/json")
    public ResponseEntity getModels() {
        return ResponseEntity.ok(CarFactory.getAvailableManufacturers());
    }
}
