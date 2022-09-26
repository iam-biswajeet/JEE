package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		//read Form -1 Data 
		String pname=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String paddrs=req.getParameter("paddrs");
		String ms=req.getParameter("ms");
		//Resd form 2 Data 
		String  f2r1=req.getParameter("f2r1");
		String  f2r2=req.getParameter("f2r2");
		pw.println("<h2>"+pname+"  "+fname+"  "+paddrs+"  "+ms+"</h2><br>");
		pw.println("<h2>"+f2r1+"  "+f2r2+"</h2>");
		pw.close();
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
