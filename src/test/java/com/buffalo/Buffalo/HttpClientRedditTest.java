package com.buffalo.Buffalo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.IOException;

@SpringBootTest
public class HttpClientRedditTest {
    @Test
    public void httpClientRedditTest() {
	HttpClientReddit testHttpClientReddit = new HttpClientReddit();
    	String testHttpClientRedditStringResult = new String();
    	try {
	    testHttpClientRedditStringResult = testHttpClientReddit.javaRedditPosts();
    	} catch (IOException e) {
	    e.printStackTrace();
            }
	assertTrue(testHttpClientRedditStringResult.length() > 300);
	assertTrue(testHttpClientRedditStringResult.contains("Title"));
	assertNotNull(testHttpClientRedditStringResult);
  }
}
