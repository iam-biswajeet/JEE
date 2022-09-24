package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("Servlet1.doGet()");
		//setting req attribute
		req.setAttribute("attr1","val1");
		RequestDispatcher rd=req.getRequestDispatcher("/s2url");
		rd.forward(req, resp);
		
		HttpSession session=req.getSession();
		session.setAttribute("attr2","val2");
		
		ServletContext sc=super.getServletContext();
		sc.setAttribute("attr3", "val3");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		this.doGet(req, resp);
	}

}
