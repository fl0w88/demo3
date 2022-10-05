/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.demo3.logic;

import com.example.demo3.controller.CalculatorController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    public double add(double... params) {
        checkArguments(params);
        double result = 0;
        for (int i = 0; i < params.length; i++) {
            result += params[i];
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    public BigDecimal add(BigDecimal... params) {
        checkArguments(params);
        BigDecimal result = new BigDecimal("0");
        for (int i = 0; i < params.length; i++) {
            result = result.add(params[i]);
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    public double multiply(double... params) {
		checkArguments(params);
        double result = 1;
        for (int i = 0; i < params.length; i++) {
            result *= params[i];
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    public BigDecimal multiply(BigDecimal... params) {
        checkArguments(params);
        BigDecimal result = new BigDecimal("1");
        for (int i = 0; i < params.length; i++) {
            result = result.multiply(params[i]);
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    public double subtract(double... params) {
		checkArguments(params);
        double result = params[0];
        for (int i = 1; i < params.length; i++) {
            result -= params[i];
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    public BigDecimal subtract(BigDecimal... params) {
        checkArguments(params);
        BigDecimal result = params[0];
        for (int i = 1; i < params.length; i++) {
            result = result.subtract(params[i]);
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    public double divide(double... params) {
		checkArguments(params);
        double result = params[0];
        for (int i = 1; i < params.length; i++) {
            if (params[i] == 0) {
                throw new IllegalArgumentException("Cannot divide something by 0.");
            }
            result /= params[i];
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    public BigDecimal divide(BigDecimal... params) {
        checkArguments(params);
        BigDecimal result = params[0];
        MathContext m = new MathContext(4);
        for (int i = 1; i < params.length; i++) {
            if (params[i].compareTo(BigDecimal.ZERO) == 0) {
                throw new IllegalArgumentException("Cannot divide something by 0.");
            }
            result = result.divide(params[i], 2, RoundingMode.HALF_UP);
        }
        LOGGER.debug("Result {}", result);
        return result;
    }

    private void checkArguments(double... params) {
		if (params.length < 2) {
            throw new IllegalArgumentException("At least two arguments must be provided!");
        }
	}

    private void checkArguments(BigDecimal... params) {
        if (params.length < 2) {
            throw new IllegalArgumentException("At least two arguments must be provided!");
        }
    }

}
