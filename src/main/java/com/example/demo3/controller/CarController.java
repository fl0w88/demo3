package com.example.demo3.controller;

import com.example.demo3.car.Car;
import com.example.demo3.car.CarFactory;
import com.example.demo3.car.CarOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CarController {

    @PostMapping(value = "/order-car", consumes = "application/json", produces = "application/json")
    public ResponseEntity orderCar(@RequestBody CarOrder carOrder) {
        Car orderedCar = CarFactory.getCar(carOrder.getManufacturer(), carOrder.getModel(), carOrder.getColor());
        return ResponseEntity.ok(orderedCar);
    }

}
