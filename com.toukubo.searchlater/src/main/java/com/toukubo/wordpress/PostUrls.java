package com.toukubo.wordpress;

import java.util.ArrayList;
import java.util.List;

public class PostUrls {
	List<String> urls = new ArrayList<String>();
	public PostUrls() {
		String username = "admin";
	    String password = "aiueo0101";
	    String xmlRpcUrl = "http://zxc.cz/wp20";
//	    Wordpress wp = new Wordpress(username, password, xmlRpcUrl);
//	    List<Page> recentPosts = wp.getRecentPosts(10);
//	    System.out.println("Here are the ten recent posts:");
//	    for (Page page : recentPosts) {
//	      System.out.println(page.getPostid() + ":" + page.getTitle());
//	    }
//	    List<PageDefinition> pages = wp.getPageList();
//	    System.out.println("Here are the pages:");
//	    for (PageDefinition pageDefinition : pages) {
//	      System.out.println(pageDefinition.getPage_title());
//	    }
//	    System.out.println("Posting a test (draft) page from a previous page...");
//	    Page recentPost = wp.getRecentPosts(1).get(0);
//	    recentPost.setTitle("Test Page");
//	    recentPost.setDescription("Test description");
//	    String result = wp.newPost(recentPost, false);
//	    System.out.println("new post page id: " + result);
//	    System.out.println("\nThat's all for now.");	
	    }
}
