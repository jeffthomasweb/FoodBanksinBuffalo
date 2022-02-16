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
    
    @CrossOrigin(origins = {"https://jeffthomasweb.github.io/","https://d1s6gdf0jyk1uk.cloudfront.net/"})
    @GetMapping("/webscrapenews")
    public List<String> npr() {
        List<String> finalResultsListNpr = new ArrayList<String>();
	WebScrape nprNewsList = new WebScrape();
	try {
	    finalResultsListNpr = nprNewsList.nprWebScrape();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return finalResultsListNpr;
    }

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
        return newsStoriesListResult;
    }
    
    @CrossOrigin(origins = {"https://jeffthomasweb.github.io/","https://d1s6gdf0jyk1uk.cloudfront.net/", "https://4dxqjt8w9c.execute-api.us-east-2.amazonaws.com/default/reddit"})
    @GetMapping("/awslambdareddit")
    public String awsLambdaRedditFunction() {
        HttpClientReddit newResponse = new HttpClientReddit();
        String newResponseResult = new String();
        try {
            newResponseResult = newResponse.javaRedditPosts();
            } catch (IOException e) {
                e.printStackTrace();
                }
            //System.out.println(newResponseResult);
            return newResponseResult;

    }
 }
