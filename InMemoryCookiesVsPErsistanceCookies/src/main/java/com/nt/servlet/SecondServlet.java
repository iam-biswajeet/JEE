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
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		Cookie[] cookies=req.getCookies();
		
		if(cookies!=null) {
			for(Cookie ck:cookies) {
				pw.println("<h1>"+ck.getName()+"  "+ck.getValue()+"</h1>");
			}
		}
		
		}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}

}
