//HtmlServlet.java
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class HtmlServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		//Set Response Content Type
		res.setContentType("text/html");
		//enable auto-refresh option
		res.setHeader("refresh","5");
		//get PrintWriter stream from response object
		PrintWriter pw=res.getWriter();
		//Write the output in response object
		//Write the logic for Current Date and Time
		pw.println("<h1 style='color:blue;text-align:center'>Todays Date and Time"+new java.util.Date()+"</h1>");
		//Olompic medal for India
		pw.println("<h1 style='color:red; text-align:center'>Olympic MedalList Of India<h1>");
		pw.println("<table border='1' align='center' width=50% height=40% style='color:white;background:green;font-size:20px'>");
		pw.println("<tr style='background:yellow'><th style='color:brown'>PlayerName</th><th style='color:brown'>Medal</th><th style='color:brown'>Sport</th></tr>");
		pw.println("<tr><td>Neeraj Chopra</td><td>Gold</td><td>Javlin Throw</td></tr>");
		pw.println("<tr><td>Meerabai Chanu</td><td>Silver</td><td>Weight Lifting</td></tr>");
		pw.println("<tr><td>Ravi Kumar</td><td>Silver</td><td>Wrestling</td></tr>");
		pw.println("<tr><td>PV Sindhu</td><td>Bronze</td><td>Badminton</td></tr>");
		pw.println("<tr><td>Lovelina BorgoHain</td><td>Bronze</td><td>Boxing</td></tr>");
		pw.println("<tr><td>Bajarang Punia</td><td>Bronze</td><td>Wrestling</td></tr>");
		pw.println("<tr><td>Indian Hockey Team</td><td>Bronze</td><td>Hockey</td></tr>");
		pw.println("</table>");
		pw.println("<h3 style='color:aqua'>Request Object name:::"+req.getClass()+"</h3>");
		pw.println("<h3 style='color:aqua'>Response Object name:::"+res.getClass()+"</h3>");
		pw.close();
	}
}