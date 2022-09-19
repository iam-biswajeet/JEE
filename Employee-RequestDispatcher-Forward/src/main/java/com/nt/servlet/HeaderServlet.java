package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/headerurl")
public class HeaderServlet extends HttpServlet {
   

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//GEt PrintWRiter
		PrintWriter pw=resp.getWriter();
		//Set Content type
		resp.setContentType("text/html");
		pw.println("<marquee><h2 style='color:blue'>N A R E S H    T E C H N O L O G Y</h2></marquee><br><br><br>");
		//pw.close();Not Recomenedd bcoz it commit the response
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}

}
