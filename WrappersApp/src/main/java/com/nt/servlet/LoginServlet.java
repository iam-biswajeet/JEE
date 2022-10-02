package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	public LoginServlet() {
		System.out.println("LoginServlet.LoginServlet()");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet.doGet()");
		//Get PrintWriter PrintWriter
		PrintWriter pw=resp.getWriter();
		//Set content Type
		resp.setContentType("text/html");
		//Read the request Parameter
		String email=req.getParameter("email");
		String pwd=req.getParameter("pwd");
		System.out.println(req.getClass()+"\n"+resp.getClass());
		System.out.println(email+"\n"+pwd);
		//b.logic
		if(email.equalsIgnoreCase("nit@gmail.com") && pwd.equalsIgnoreCase("nit")) {
			pw.println("<h1 style='color:red;text-align:center'>Login Success</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Login Failed</h1>");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
