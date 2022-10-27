package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set response content type
		res.setContentType("text/html");
		//get printwriter
		PrintWriter pw=res.getWriter();
		//write the response object
		pw.println("<h1>Welcome Servlet</h1>");
		pw.close();
	}
}
