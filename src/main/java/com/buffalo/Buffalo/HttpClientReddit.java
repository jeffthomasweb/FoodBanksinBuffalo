package com.buffalo.Buffalo;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import java.net.*;
import java.net.http.*;
import java.io.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.lang.InterruptedException;

public class HttpClientReddit {
    String javaRedditPosts() throws IOException {
        HttpClient httpClient = HttpClient.newHttpClient();
        String httpResponseBody = new String();
        try { 
	    HttpRequest httpRequest = HttpRequest.newBuilder(new URI("https://4dxqjt8w9c.execute-api.us-east-2.amazonaws.com/default/reddit")).build();
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
	    httpResponseBody = httpResponse.body();
	    } catch (IOException | URISyntaxException | InterruptedException e) {
                e.printStackTrace();
            }
        return httpResponseBody;             
    }
}
