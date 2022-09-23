package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw=resp.getWriter();
		//set Content
		resp.setContentType("text/html");
		//Read the Request Parameter
		String ss=req.getParameter("ss");
		String engine=req.getParameter("engine");
		String query=null;
		//write the B.logic for sendRedirection
		if(engine.equalsIgnoreCase("google"))
			query="https://www.google.com/search?q="+ss;
		else if(engine.equalsIgnoreCase("yahoo"))
			query="https://in.search.yahoo.com/search?p="+ss;
		if(engine.equalsIgnoreCase("bing"))
			query="https://www.bing.com/search?q="+ss;
		resp.sendRedirect(query);
		pw.close();
	
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		this.doGet(req, resp);
	}

}
