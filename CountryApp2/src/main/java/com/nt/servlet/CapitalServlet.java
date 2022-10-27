package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CapitalServlet extends HttpServlet {
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		int country=Integer.parseInt(req.getParameter("country"));
		String[] countries= {"india","aus","eng","rsa"};
		String[] capital= {"Delhi","melbourn","london","capetown"};
		pw.println("<h1 style='color:red;text-align:center'>capital Of "+countries[country]+" is "+capital[country]+"</h1>");
		pw.println("<a href='home.html'>home</a>");
		pw.close();
	}
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
