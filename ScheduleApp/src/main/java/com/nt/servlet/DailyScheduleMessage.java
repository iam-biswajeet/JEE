package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DailyScheduleMessage extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//obtain PrintWriter object from response object
		PrintWriter pw=res.getWriter();
		//Set Content Type
		res.setContentType("text/html");
		//Write The business logic
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		pw.println("<h2 style='color:blue;text-align:center'>My Dailly Schedule</h2>");
		if(hour>8 && hour<12)
			pw.println("<h1 style='color:red;text-align:center'>Servlet Study Time</h1>");
		else if(hour>12 && hour<13)
			pw.println("<h1 style='color:red;text-align:center'>lunch Time</h1>");
		else if(hour>13 && hour<15)
			pw.println("<h1 style='color:red;text-align:center'>Rest Time</h1>");
		else if(hour>15 && hour<18)
			pw.println("<h1 style='color:red;text-align:center'>JDBC Study Time</h1>");
		else if(hour>18 && hour<19)
			pw.println("<h1 style='color:red;text-align:center'>Snack Time</h1>");
		else if(hour>19 && hour<21)
			pw.println("<h1 style='color:red;text-align:center'>Core Java Study Time</h1>");
		else if(hour>21 && hour<22)
			pw.println("<h1 style='color:red;text-align:center'>Dinner Time</h1>");
		else if(hour>6 && hour<7)
			pw.println("<h1 style='color:red;text-align:center'>BreakFast Time</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>Sleep Time</h1>");
		pw.println("<a href='home.html'>home</a>");
	}
}
