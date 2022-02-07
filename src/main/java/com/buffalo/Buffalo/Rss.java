package com.buffalo.Buffalo;

import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
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

public class Rss {
    public List<String> buffalonews(String x) throws IOException {

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
                     //resultsnews.add(title);
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

