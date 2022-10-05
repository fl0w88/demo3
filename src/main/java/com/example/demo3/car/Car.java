package com.example.demo3.car;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Random;

@Getter
@Setter
public class Car extends CarOrder implements Vehicle {

    private final String serialNumber;

    private String picture = "\uD83D\uDE97";
    private BigDecimal priceInEUR = new BigDecimal(new Random().nextInt((500000 - 10000) + 10000));

    public Car(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
