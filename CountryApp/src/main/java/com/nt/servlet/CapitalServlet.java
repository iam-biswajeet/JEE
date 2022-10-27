package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CapitalServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType(getServletInfo());
		//request processing
		int country=Integer.parseInt(req.getParameter("country"));
		String[] countries= {"indai","Aus","eng","rsa"};
		String[] capital= {"Delhi","Melbourne","London","Capetown"};
		
		pw.println("<h1 style='color:red text-align:center>The capital of::"+countries[country]+" is "+capital[country]+"</h1>");
		
		pw.println("<a href='home.html>home</a>");
		pw.close();
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
