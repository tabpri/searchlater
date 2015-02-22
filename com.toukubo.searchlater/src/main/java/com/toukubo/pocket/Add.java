package com.toukubo.pocket;

import net.arnx.jsonic.JSON;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Add {
	public Add(String url){
		HttpClient httpClient = new DefaultHttpClient();

	    try {
	    	Article article = new Article();
	    	article.setUrl(url);
	    	
	        HttpPost request = new HttpPost("https://getpocket.com/v3/add");
	        String jsonString = JSON.encode(article);
	        System.err.println(jsonString);
			StringEntity params =new StringEntity(jsonString );
	        request.addHeader("content-type", "application/x-www-form-urlencoded");
	        request.setEntity(params);
	        HttpResponse response = httpClient.execute(request);
	        System.err.println(response.toString());

	        // handle response here...
	    }catch (Exception ex) {
	        // handle exception here
	    } finally {
	        httpClient.getConnectionManager().shutdown();
	    }
	}
	public static void main(String[] args) {
		new Add("http://stackoverflow.com/questions/7181534/http-post-using-json-in-java");
	}
}
