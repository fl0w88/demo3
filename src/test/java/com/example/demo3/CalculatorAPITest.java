package com.example.demo3;

import com.example.demo3.model.model.CalculationRequest;
import com.example.demo3.model.model.CalculationResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorAPITest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	@DisplayName("Testing calculator operation: addition \uD83D\uDE80")
	public void additionTest() {
		CalculationRequest request = new CalculationRequest();
		request.setNumber1(new BigDecimal("2"));
		request.setNumber2(new BigDecimal("3"));
		request.setOperation("+");

		this.webTestClient
				.post()
				.uri("/api/calculator")
				.body(Mono.just(request), CalculationRequest.class)
				.exchange()
				.expectStatus().is2xxSuccessful() // check status code
				.expectBody(CalculationResponse.class)
				.consumeWith(result -> assertEquals(new BigDecimal("5"), result.getResponseBody().getResult()));
	}

	@Test
	@DisplayName("Testing calculator operation: multiplication \uD83D\uDE80")
	public void multiplicationTest() {
		CalculationRequest request = new CalculationRequest();
		request.setNumber1(new BigDecimal("2"));
		request.setNumber2(new BigDecimal("3"));
		request.setOperation("*");

		this.webTestClient
				.post()
				.uri("/api/calculator")
				.body(Mono.just(request), CalculationRequest.class)
				.exchange()
				.expectStatus().is2xxSuccessful() // check status code
				.expectBody(CalculationResponse.class)
				.consumeWith(result -> assertEquals(new BigDecimal("6"), result.getResponseBody().getResult()));
	}

	@Test
	@DisplayName("Testing calculator operation: division \uD83D\uDE80")
	public void divisionTest() {
		CalculationRequest request = new CalculationRequest();
		request.setNumber1(new BigDecimal("15"));
		request.setNumber2(new BigDecimal("3"));
		request.setOperation("/");

		this.webTestClient
				.post()
				.uri("/api/calculator")
				.body(Mono.just(request), CalculationRequest.class)
				.exchange()
				.expectStatus().is2xxSuccessful() // check status code
				.expectBody(CalculationResponse.class)
				.consumeWith(result -> assertTrue(new BigDecimal("5")
						.compareTo(result.getResponseBody().getResult()) == 0));
	}

	@Test
	@DisplayName("Testing calculator operation: subtraction \uD83D\uDE80")
	public void subtractionTest() {
		CalculationRequest request = new CalculationRequest();
		request.setNumber1(new BigDecimal("5"));
		request.setNumber2(new BigDecimal("3"));
		request.setOperation("-");

		this.webTestClient
				.post()
				.uri("/api/calculator")
				.body(Mono.just(request), CalculationRequest.class)
				.exchange()
				.expectStatus().is2xxSuccessful() // check status code
				.expectBody(CalculationResponse.class)
				.consumeWith(result -> assertEquals(new BigDecimal("2"), result.getResponseBody().getResult()));
	}
}
