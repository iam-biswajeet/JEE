//WordServlet.java
package com.nt.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class WordServlet extends HttpServlet{
	protected void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		//Set Response Content Type
		res.setContentType("application/msword");
		//get PrintWriter stream from response object
		PrintWriter pw=res.getWriter();
		//Write the output in response object
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>PlayerName</th><th>Medal</th><th>Sport</th></tr>");
		pw.println("<tr><td>Neeraj Chopra</td><td>Gold</td><td>Javlin Throw</td></tr>");
		pw.println("<tr><td>Meerabai Chanu</td><td>Silver</td><td>Weight Lifting</td></tr>");
		pw.println("<tr><td>Ravi Kumar</td><td>Silver</td><td>Wrestling</td></tr>");
		pw.println("<tr><td>PV Sindhu</td><td>Bronze</td><td>Badminton</td></tr>");
		pw.println("<tr><td>Lovelina BorgoHain</td><td>Bronze</td><td>Boxing</td></tr>");
		pw.println("<tr><td>Bajarang Punia</td><td>Bronze</td><td>Wrestling</td></tr>");
		pw.println("<tr><td>Indian Hockey Team</td><td>Bronze</td><td>Hockey</td></tr>");
		pw.println("</table>");
		pw.close();
	}
}