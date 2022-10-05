package com.example.demo3.controller;

import com.example.demo3.logic.Calculator;
import com.example.demo3.model.model.CalculationRequest;
import com.example.demo3.model.model.CalculationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @PostMapping(value = "/calculator", consumes = "application/json", produces = "application/json")
    public ResponseEntity calculator(@RequestBody CalculationRequest calculationRequest) {
        Calculator calc = new Calculator();
        BigDecimal r = null;
        if (calculationRequest.getOperation().trim().equals("+")) {
            r = calc.add(calculationRequest.getNumber1(), calculationRequest.getNumber2());
        }
        if (calculationRequest.getOperation().trim().equals("-")) {
            r = calc.add(calculationRequest.getNumber1(), calculationRequest.getNumber2());
        }
        if (calculationRequest.getOperation().trim().equals("*")) {
            r = calc.multiply(calculationRequest.getNumber1(), calculationRequest.getNumber2());
        }
        if (calculationRequest.getOperation().trim().equals("/")) {
            r = calc.divide(calculationRequest.getNumber1(), calculationRequest.getNumber2());
        }
        if (r == null) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }
        return ResponseEntity.ok(new CalculationResponse(r));
    }

}
