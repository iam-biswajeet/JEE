package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//Create Http SAeason
		HttpSession session=req.getSession(true);
		session.setAttribute("pname",pname);
		session.setAttribute("fname",fname);
		session.setAttribute("paddrs",paddrs);
		session.setAttribute("ms",ms);
		
		pw.println("<h1>session id::"+session.getId()+"</h1>");
		System.out.println(pname+"  "+fname+"  "+paddrs+"  "+ms);
		pw.println("<h1 style='text-align:center;color:red'>Registration Form-2</h1>");
		
		pw.println("<form action='"+resp.encodeURL("secondurl")+"' method='POST'>");
		pw.println("<table align='center' bgcolor='blue'>");
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<tr><td>Spouse NAme::</td><td><input type='text' name='f2r1'></td></tr>");
			
				pw.println("<tr><td>No of child::</td><td><input type='text' name='f2r2'></td></tr>");
		
		}
		else {
			pw.println("<tr><td>Why are you want to marry::</td><td><input type='text' name='f2r1'></td></tr>");
		
				pw.println("<tr><td>When You MArry:</td><td><input type='text' name='f2r2'></td></tr>");
							
		}
		
		pw.println("<tr><td><input type='submit' value='register'></td><td><input type='reset' value='reset'></td></tr>");
		pw.println("</table>");
		
		//pw.println("<input type='hidden' name='hms' value='"+ms+"'>");
		pw.println("</form>");
		pw.close();
			
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doGet(req, resp);
	}

}
