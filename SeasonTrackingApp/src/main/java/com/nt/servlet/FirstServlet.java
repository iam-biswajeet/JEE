package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		//Read Form 1 Input
		String pname=req.getParameter("pname");
		String fname=req.getParameter("fname");
		String paddrs=req.getParameter("paddrs");
		String ms=req.getParameter("ms");
		System.out.println(pname+"  "+fname+"  "+paddrs);
		pw.println("<h1 style='text-align:center;color:red'>Registration Form-2</h1>");
		
		pw.println("<form action='secondurl' method='POST'>");
		pw.println("<table align='center' bgcolor='blue'>");
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<tr><td>Spouse NAme::</td><td><input type='text' name='f2r1'></td></tr>");
			
				pw.println("<tr><td>No of child::</td><td><input type='text' name='f2r2'></td></tr>");
		
		}
		else {
			pw.println("<tr><td>Why are you MArried::</td><td><input type='text' name='f2r1'></td></tr>");
		
				pw.println("<tr><td>When You MArried::</td><td><input type='text' name='f2r2'></td></tr>");
							
		}
		pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='reset'></td></tr>");
		pw.println("</table></form>");
		pw.close();
			
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
