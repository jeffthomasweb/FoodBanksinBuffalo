package com.buffalo.Buffalo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;

import java.net.*;
import java.net.http.*;
import java.io.*;
import org.xml.sax.InputSource;

@RestController
public class MainController {
    @Autowired 
    private BuffaloRepository buffaloRepository;

    @CrossOrigin(origins = {"https://jeffthomasweb.github.io/","https://d1s6gdf0jyk1uk.cloudfront.net/"})
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Buffalo> getAllBuffalo() {
      return buffaloRepository.findAll();
    }
    

   /*  @GetMapping("/webscrapenews")
    public List<String> feed() throws IOException {
        List<String> results = new ArrayList<String>();
        Document doc = Jsoup.connect("https://text.npr.org/1001").get();
        Elements links = doc.getElementsByTag("a");
	    for (Element link : links) {
  	    String linkText = link.text();
  	    results.add(linkText);
	    }

        List<String> resultsFinal = new ArrayList<String>();

	resultsFinal = results.subList(2,21);

	return resultsFinal;
} */

    @CrossOrigin(origins = {"https://jeffthomasweb.github.io/","https://d1s6gdf0jyk1uk.cloudfront.net/"})
    @GetMapping("/buffalonews")
    public List<String> buffalonewsrss() {
        Rss newsStoriesClass = new Rss();
        String site = "https://www.wgrz.com/feeds/syndication/rss/news/local";
        List<String> newsStoriesListResult = new ArrayList<String>();
        try {
	    newsStoriesListResult = newsStoriesClass.buffalonews(site);
        } catch (IOException e) {
	    e.printStackTrace();
        }
        //System.out.println(testspring);
            return newsStoriesListResult;
    }
      }
