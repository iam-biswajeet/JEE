package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get the printWriter object
		PrintWriter pw=res.getWriter();
		//set ContentType
		res.setContentType("text/html");
		//write the business logic to generate wish message
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		pw.println("<h1 style='color:red;text-align:center'>"+ldt+"<h1>");
		if(hour<12)
			pw.println("<h2 style='text-align:center;color:blue'>Good Morning</h2>");
		else if(hour<16)
			pw.println("<h2 style='text-align:center;color:blue'>Good AfterNoon</h2>");
		else if(hour<20)
			pw.println("<h2 style='text-align:center;color:blue'>Good Evening</h2>");
		else
			pw.println("<h2 style='text-align:center;color:blue'>Good Night</h2>");
		pw.println("<a href='home.html'>home</a>");
		
	}

}
