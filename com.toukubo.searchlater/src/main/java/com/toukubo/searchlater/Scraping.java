package com.toukubo.searchlater;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scraping {
	List<String> urls = new ArrayList<String>();
	public static void main(String[] args) {
		Scraping scraping = new Scraping();
		new ListToTexts(scraping.getUrls());
	}
	public Scraping() {    
		Document doc;
		try{
			String query = "java+wordpress+maven";
			doc =        Jsoup.connect("https://www.google.com/search?as_q=&as_epq=%22"+query+"%22+&as_oq=fraud+OR+allegations+OR+scam&as_eq=&as_nlo=&as_nhi=&lr=lang_en&cr=countryCA&as_qdr=all&as_sitesearch=&as_occt=any&safe=images&tbs=&as_filetype=&as_rights=").userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();
			Elements links = doc.select("li[class=g]");
			for (Element link : links) {
				Elements titles = link.select("h3[class=r]");
				String title = titles.text();
				String url = link.select("a").attr("href");
				url = url.replaceAll("/url\\?q=", "");

				Elements bodies = link.select("span[class=st]");
				String body = bodies.text();
				//				urls.add(link.select("));
				urls.add(url);

				System.out.println("Title: "+title);
				System.out.println("URL: "+ url);
				System.out.println("Body: "+body+"\n");
			}


		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	public List<String> getUrls() {
		return urls;
	}

}
