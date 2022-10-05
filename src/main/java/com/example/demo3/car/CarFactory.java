package com.example.demo3.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class CarFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarFactory.class);

    public static Car getCar(String manufacturer, String model, String color) {
        String serialNumber = UUID.randomUUID().toString();
        Car car = new Car(serialNumber);
        LOGGER.debug("New car created with serial number: {}.", car.getSerialNumber());
        car.setColor(color);
        car.setModel(model);
        car.setManufacturer(manufacturer);
        LOGGER.debug("Painting car in color: {}.", car.getColor());
        return car;
    }

}
