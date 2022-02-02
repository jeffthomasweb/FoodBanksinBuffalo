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

    @GetMapping("/buffalonews")
    public List<String> buffalonews() throws IOException {
        String x = "https://www.wgrz.com/feeds/syndication/rss/news/local";

	HttpClient myhc = HttpClient.newHttpClient();
	List<String> resultsnews = new ArrayList<String>();
	try {
	    HttpRequest myreq = HttpRequest.newBuilder(new URI(x)).build();
	    HttpResponse<String> myresp = myhc.send(myreq, HttpResponse.BodyHandlers.ofString());
	    String resp = myresp.body();        
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

         
                
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document docnews = db.parse(new InputSource(new StringReader(resp)));
            docnews.getDocumentElement().normalize();

            NodeList list = docnews.getElementsByTagName("item");
            
            for (int temp = 0; temp < list.getLength(); temp++) {

                 Node node = list.item(temp);

              	 if (node.getNodeType() == Node.ELEMENT_NODE) {

                     Element element = (Element) node;

                     String title = element.getElementsByTagName("title").item(0).getTextContent();
	             String description = element.getElementsByTagName("description").item(0).getTextContent();
		     resultsnews.add(title + ". " + description);

			}
			
			}
	
	    } catch (ParserConfigurationException | SAXException | IOException | URISyntaxException e) {
                e.printStackTrace();
            } catch (Exception e) {
		e.printStackTrace();
	    }
	    
	    return resultsnews; 
	}
      }
