package com.programming.microservices.product;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.hamcrest.Matchers;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers //// 🔁 Tells JUnit this test uses Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //uns the entire Spring Boot app on a random port — mimics real behavior and avoids port clashes
class ProductServiceApplicationTests {

     @LocalServerPort
     private Integer port;
	 //Injects the port Spring Boot picked at runtime — needed to configure RestAssured.

	// Automatically starts/stops container and binds to Spring MongoDB config
	 @Container
	 //This annotation tells Spring Boot to automatically wire the Testcontainers instance (MongoDB) as the application’s data source. It's Spring Boot 3.1+ feature — super clean!
	 @ServiceConnection
	static MongoDBContainer mongoDBContainer= new MongoDBContainer("mongo:7.0.5");

	@BeforeEach
	void setUp(){
		//RestAssured is used to do Rest API calls
		//Sets up RestAssured to target your Spring Boot app’s base URI and the actual runtime port.
		//This ensures your .post(...) and .get(...) calls work properly.
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}



	@Test
	void shouldCreateProduct() {
		String requestBody = """
			{
				"name": "Iphone 16",
				"description": "Latest iphone",
				"price": 1100
			}
			""";

    RestAssured.given()
			.contentType("application/json")
			.body(requestBody)
			.when()
			.post("/api/product")
			.then()
			.statusCode(201)
			.body("id", Matchers.notNullValue())
			.body("name", Matchers.equalTo("Iphone 16"))
			.body("description", Matchers.equalTo("Latest iphone"))
			.body("price", Matchers.equalTo(1100));


	}

}
