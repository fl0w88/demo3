package com.example.demo3;

import com.example.demo3.car.Car;
import com.example.demo3.car.CarOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarOrderTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @DisplayName("Autobestellung von Fritz")
    public void carOrderTest() {
        // Bestelle mindestens 100 Autos in 3 unterschiedliche Farben
        for (int i = 0; i <= 100; i++) {
            CarOrder request = new CarOrder();
            if (i < 30) {
                request.setColor("red");
            } else if (i >= 30 && i < 60) {
                request.setColor("white");
            } else {
                request.setColor("blue");
            }
            request.setManufacturer("BMW");

            this.webTestClient
                    .post()
                    .uri("/api/cars/orders")
                    .body(Mono.just(request), CarOrder.class)
                    .exchange()
                    .expectStatus().is2xxSuccessful() // check status code
                    .expectBody(Car.class)
                    .consumeWith(result -> {
                        assertNotNull(result.getResponseBody().getColor());
                        assertTrue(result.getResponseBody().getPriceInEuro()
                                .compareTo(new BigDecimal("1000")) > 0);
                    });
        }
    }
}
