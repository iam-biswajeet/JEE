package com.nt.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageEligibilityTestServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get pw object
		PrintWriter pw=res.getWriter();
		//Request processing logic
		pw.println("<h1 style='color:blue; text-align:center'>Marriage Permission Approval form</h1>");
		String pname=req.getParameter("pname");
		int page=Integer.parseInt(req.getParameter("page"));
		String gender=req.getParameter("gender");
		if(gender.equals("male") && page>21) {
			pw.println("<h2 style='color:green'>You are  eligible for marriage</h2>");
			pw.println("<h2 style='color:green'>Go to matrimonial site definitely you will get a perfect match</h2>");
		}
		else if(gender.equals("female") && page>18) {
			pw.println("<h2 style='color:green'>You are  eligible for marriage</h2>");
			pw.println("<h2 style='color:green'>Go to matrimonial site definitely you will get a perfect match</h2>");
		}
		else {
			pw.println("<h2 style='color:red'>You are  Not eligible for marriage</h2>");
		pw.println("<h2 style='color:red'>A/c to Indian constitution You not eligible if you marry you may punished for that </h2>");
		}
		pw.println("<a href='marriage_form.html'>Home</a>");
	}
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			//set content type
			res.setContentType("text/html");
			//get printwriter object
			PrintWriter pw=res.getWriter();
			//write the response logic
			LocalDateTime ldt=LocalDateTime.now();
			int hour=ldt.getHour();
			if(hour<12)
				pw.println("<h1>Good Morning</h1>");
			if(hour<16)
				pw.println("<h1>Good AfterNoon</h1>");
			if(hour<20)
				pw.println("<h1>Good Evening</h1>");
			else
				pw.println("<h1>Good Morning</h1>");
		
	}
}
