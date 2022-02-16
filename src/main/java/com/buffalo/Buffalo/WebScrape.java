package com.buffalo.Buffalo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebScrape {
	List<String> nprWebScrape() throws IOException {
            List<String> resultsNpr = new ArrayList<String>();
            List<String> resultsFinalNpr = new ArrayList<String>();
	    try {
                Document docNpr = Jsoup.connect("https://text.npr.org/1001").get();
                Elements linksNpr = docNpr.getElementsByTag("a");
                for (Element singleLinkNpr : linksNpr) {
                    String linkTextNpr = singleLinkNpr.text();
                    resultsNpr.add(linkTextNpr);
                }
                //List<String> resultsFinalNpr = new ArrayList<String>();
                resultsFinalNpr = resultsNpr.subList(2,21);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return resultsFinalNpr;
    }
}
