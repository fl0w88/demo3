package com.example.demo3.bdd.steps;

import com.example.demo3.model.model.CalculationRequest;
import com.example.demo3.model.model.CalculationResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorTest {

    @Autowired
    private WebTestClient webTestClient;

    private CalculationResponse result;

    @Given("^I am using my calculator$")
    public void initCalculator() {
    }

    @When("^I add (.+) and (.+)$")
    public void addNumbers(String a, String b) {
        CalculationRequest request = new CalculationRequest();
        request.setNumber1(new BigDecimal(a));
        request.setNumber2(new BigDecimal(b));
        request.setOperation("+");

        this.webTestClient
                .post()
                .uri("/api/calculator")
                .body(Mono.just(request), CalculationRequest.class)
                .exchange()
                .expectStatus().is2xxSuccessful() // check status code
                .expectBody(CalculationResponse.class)
                .consumeWith(result -> this.result = result.getResponseBody());
    }

    @Then("^I get the result (.+)$")
    public void verifyResult(double e) {
        Assertions.assertEquals(e, result.getResult().doubleValue());
    }

}
