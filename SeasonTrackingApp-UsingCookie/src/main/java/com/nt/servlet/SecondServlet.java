package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		//read Form -1 Data 
		Cookie[] cookies=req.getCookies();
		String pname=cookies[0].getValue();
		String fname=cookies[1].getValue();
		String paddrs=cookies[2].getValue();
		String ms=cookies[3].getValue();
		//Resd form 2 Data 
		String  f2r1=req.getParameter("f2r1");
		String  f2r2=req.getParameter("f2r2");
		pw.println("<h1>Form Data Of Form 1</h1>");
		pw.println("<h2>PERSON NAME::"+pname+"<br>FATHER NAME::"+fname+"<br>ADDRESS"+paddrs+"<br>MARETAL STATUS"+ms+"</h2><br>");
		pw.println("<h1>Form Data Of Form 2</h1>");
		if(ms.equalsIgnoreCase("married"))
			pw.println("<h2>SPOUSE NAME::"+f2r1+"<br>NO OF KIDS::"+f2r2+"</h2>");
		else
			pw.println("<h2>WHY ARE YOU MARRY::"+f2r1+"<br>WHEN DO YOU MARRY::"+f2r2+"</h2>");
		pw.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
