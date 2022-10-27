package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineEligibilityServlet extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
		//process the request object and get the request object parameter
		String uname=req.getParameter("uname").toUpperCase();
		String uaddrs=req.getParameter("uaddrs").toUpperCase();
		String age=req.getParameter("uage");
		int uage=Integer.parseInt(age);
		//set contenttype
		res.setContentType("text/html");
		//get the PrintWriter object from response object
		PrintWriter pw=res.getWriter();
		LocalDate d=LocalDate.now();
		if(uage>18) {
			pw.println("<h1 style='color:blue'>Vaccination Schedule</h1>");
			pw.println("<h3 style='color:green'>"+uname+" You are eligible for vaccination</h3>");
			pw.println("<h3 style='color:green'>Your vaccination center name ::"+uaddrs+" on "+d+"</h3>");
		}
		else {
			pw.println("<h3 style='color:red'>"+uname+" Sorry You are not eligible for vaccination</h3>");
			pw.println("<h3 style='color:red'>"+uname+" please wait until you turned up 18 years</h3>");
			
		}
		pw.println("<a href='homeurl'><img src='images/home.jfif'></a>");
		pw.close();
	}
}
