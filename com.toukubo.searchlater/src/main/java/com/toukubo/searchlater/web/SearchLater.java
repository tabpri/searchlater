package com.toukubo.searchlater.web;

import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toukubo.searchlater.ListToTexts;
import com.toukubo.searchlater.Scraping;

	@WebServlet("/SearchLater")
	public class SearchLater extends HttpServlet{

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        try {
	        	response.setHeader("Access-Control-Allow-Origin", "*");
	    		Scraping scraping = new Scraping(request.getParameter("query"));
	    		System.err.println("--------------------");
	    		System.err.println("-------------------- query: "+ request.getParameter("query"));
	    		new ListToTexts(scraping.getUrls());

	        	
	    		OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");
	    		writer.write("success");
	    		writer.flush();
	    		writer.close();
	        	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
//			response.getWriter().write(conversion.getResult());
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
		}

	}
