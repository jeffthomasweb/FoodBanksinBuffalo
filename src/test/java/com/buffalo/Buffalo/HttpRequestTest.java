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
	};

	@Test
        public void testBaseUrlContainsHtmlFragmentDoctype() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
                                String.class)).contains("DOCTYPE");
        }

	@Test
        public void testNewsUrlContainsHtmlFragmentDoctype() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/news.html",
                                String.class)).contains("DOCTYPE");
        }

	@Test
        public void testNewsUrlContainsHtmlFragmentBoldTag() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/news.html",
                                String.class)).contains("<b>");
        }

	
	//Test for HTML content that should be on HTML page.
	@Test
        public void testNewsUrlContainsHtmlFragmentCssContentMedium() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/news.html",
                                String.class)).contains("content is-medium");
        }

	@Test
        public void testWebScrapeUrlContainsHtmlFragmentDoctype() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/nationalnews.html", String.class)).contains("DOCTYPE");
        }
        @Test
        public void testWebScapeUrlContainsHtmlFragmentCssContentMedium() throws Exception {
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/nationalnews.html", String.class)).contains("content is-medium");
        }
}
