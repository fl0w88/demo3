package com.example.demo3.model.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalculationRequest {

    private BigDecimal number1;
    private BigDecimal number2;
    private String operation;

}
