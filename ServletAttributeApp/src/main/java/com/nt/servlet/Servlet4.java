package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/s4url")
public class Servlet4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
			pw.println("<h1>the value of req attibute s4::"+req.getAttribute("attr1")+"</h1>");
			HttpSession session=req.getSession();
			pw.println("seassion attribute s2::"+session.getAttribute("attr2"));
			
			ServletContext sc=super.getServletContext();
			pw.println("<h1>Context Attribute s4::"+sc.getAttribute("attr3")+"</h1>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
