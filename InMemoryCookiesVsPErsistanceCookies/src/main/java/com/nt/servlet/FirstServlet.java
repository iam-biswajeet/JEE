package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//set content type
		resp.setContentType("text/html");
		//PrintWRiter 
		PrintWriter pw=resp.getWriter();
		//InMemoryCookies
		Cookie ck1=new Cookie("odisha","bbsr");
		Cookie ck2=new Cookie("telengna","hyd");
		//PErsistance Coockies
		Cookie ck3=new Cookie("MAharastra","mumbai");
		Cookie ck4=new Cookie("Karnatak","BAnglore");
		ck3.setMaxAge(60);
		ck4.setMaxAge(120);
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		resp.addCookie(ck3);
		resp.addCookie(ck4);
		pw.println("<h1 style='text-align:center'>Cookies Added SUccessFuly</h1>");
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
