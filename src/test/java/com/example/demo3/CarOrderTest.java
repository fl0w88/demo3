package com.example.demo3;

import com.example.demo3.car.Car;
import com.example.demo3.car.CarOrder;
import com.example.demo3.model.model.CalculationRequest;
import com.example.demo3.model.model.CalculationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarOrderTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Autobestellung von Fritz")
    public void carOrderTest() {
        // Bestelle mindestens 100 Autos in 3 unterschiedliche Farben

    }
}
