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

	@Test
	public void testApiContainsNameOfFoodPantry() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/all",
				String.class)).contains("Belle Center Food Pantry");
	}

	@Test
        public void testBaseUrlContainsHtml() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                                String.class)).contains("DOCTYPE");
        }

	@Test
        public void testNewsUrlContainsHtml() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/news.html",
                                String.class)).contains("DOCTYPE");
        }

}
