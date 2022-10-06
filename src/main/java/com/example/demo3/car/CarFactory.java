package com.example.demo3.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.List;
import java.util.UUID;

public class CarFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarFactory.class);
    private static final List<String> availableColors = Arrays.asList("white", "blue", "red", "yellow", "purple", "black", "grey");
    private static final List<String> availableManufacturers = Arrays.asList("DACIA", "BMW", "SEAT", "AUDI", "VW", "MERCEDES", "RENAULT");

    public static Car buildCar(String manufacturer, String model, String color) throws InvalidPropertiesFormatException {
        String serialNumber = UUID.randomUUID().toString();
        Car car = new Car();
        car.setSerialNumber(serialNumber);
        LOGGER.debug("New car created with serial number: {}.", car.getSerialNumber());
        if (availableManufacturers.contains(manufacturer)) {
            car.setManufacturer(manufacturer);
        } else {
            throw new InvalidPropertiesFormatException("manufacturer");
        }
        if (availableColors.contains(color)) {
            car.setColor(color);
            LOGGER.debug("Painting car in color: {}.", car.getColor());
        } else {
            throw new InvalidPropertiesFormatException("color");
        }
        car.setModel(model);
        return car;
    }

    public static List<String> getAvailableColors() {
        return availableColors;
    }

    public static List<String> getAvailableManufacturers() {
        return availableManufacturers;
    }

}
