package com.toukubo.searchlater.cron;

import java.util.Date;

import com.toukubo.searchlater.ListToTexts;
import com.toukubo.searchlater.Scraping;

public class CronTask implements Runnable {

	public void run() {
		System.out.println(new Date()+": Hello cron4j!");
		Scraping scraping = new Scraping("iphone");
		new ListToTexts(scraping.getUrls());
	}

}
