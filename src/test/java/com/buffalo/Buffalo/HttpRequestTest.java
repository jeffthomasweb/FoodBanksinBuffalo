package com.buffalo.Buffalo;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	//Integration test. Belle Center Food Pantry is the name of a pantry that should be displayed in the API.
	@Test
	public void testApiContainsNameOfFoodPantry() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/all",
				String.class)).contains("Belle Center Food Pantry");
	}

	//Test that the base URL / displays HTML.
	@Test
        public void testBaseUrlContainsHtml() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                                String.class)).contains("DOCTYPE");
        }

}
