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
public class RssTest {
    @Test
    public void rsstest() {
        Rss tests = new Rss();
        String site = "https://www.wgrz.com/feeds/syndication/rss/news/local";
        List<String> testspring = new ArrayList<String>();
        try {
            testspring = tests.buffalonews(site);
        } catch (IOException e) {
            e.printStackTrace();
            }
        assertTrue(testspring.size() > 10);
        assertNotNull(testspring);
    }
}
