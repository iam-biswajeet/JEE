package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/testurl")
public class TestServlet extends HttpServlet  implements SingleThreadModel {
	public TestServlet() {
		System.out.println("TestServlet.TestServlet()");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		Date d=new Date();
		try{
			Thread.sleep(10000);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
			
		}
		pw.println("<h1>current date::"+d+"</h1>");
	}

}
