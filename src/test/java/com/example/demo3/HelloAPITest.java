package com.example.demo3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloAPITest {

	@Autowired
	private WebTestClient webTestClient; // available with Spring WebFlux

	// Task 1: Find the error
	@Test
	@DisplayName("Testing hello API \uD83D\uDC4B")
	void helloTest() {
		this.webTestClient
				.get()
				.uri("/api/hello")
				.exchange()
				.expectStatus().is2xxSuccessful();
	}

}
