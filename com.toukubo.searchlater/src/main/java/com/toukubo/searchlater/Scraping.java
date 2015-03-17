package com.toukubo.searchlater;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraping {
	List<String> urls = new ArrayList<String>();
	public static void main(String[] args) {
		Scraping scraping = new Scraping("ipad");
//		new ListToTexts(scraping.getUrls());
	}
	public Scraping(String query) {
		try{
			query = URLEncoder.encode(query,"utf-8");
		Document doc;
//			query = "java+wordpress+maven";
			doc =        Jsoup.connect("https://www.google.com/search?q="+query+"&oq="+query+"&es_sm=91&ie=UTF-8").userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
			Elements links = doc.select("li[class=g]");
			int i = 0;
			for (Element link : links) {
				Elements titles = link.select("h3[class=r]");
				String title = titles.text();
				String url = link.select("a").attr("href");
				url = url.replaceAll("/url\\?q=", "");
				url = url.split("&sa")[0];

				Elements bodies = link.select("span[class=st]");
				String body = bodies.text();
				//				urls.add(link.select("));
				urls.add(url);
				new Mail(url);

				System.out.println("Title: "+title);
				System.out.println("URL: "+ url);
				System.out.println("Body: "+body+"\n");
				i++;
				if ( i == 5){
					break;
				}
			}


		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	public List<String> getUrls() {
		return urls;
	}

}
