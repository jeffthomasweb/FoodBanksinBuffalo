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
public class WebScrapeTest {
    @Test
    public void webscrapetest() {
	WebScrape testwebscrape = new WebScrape();
    	List<String> testwebscrapeList = new ArrayList<String>();
    	try {
	    testwebscrapeList = testwebscrape.nprwebscrape();
    	} catch (IOException e) {
	    e.printStackTrace();
            }
	assertTrue(testwebscrapeList.size() > 10);
	assertNotNull(testwebscrapeList);
    }
}
