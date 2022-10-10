package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/linksurl")
public class LinksServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	
	String url=req.getParameter("url");
	//Write b logic
	Locale[] locales=Locale.getAvailableLocales();
	if(url.equalsIgnoreCase("country")) {
		for(Locale l:locales) {
			pw.println("<b>"+l.getDisplayCountry()+",</b>");
		}
	}
	if(url.equalsIgnoreCase("lang")) {
		for(Locale l:locales) {
			pw.println("<b>"+l.getDisplayLanguage()+",</b>");
		}
		
	}
	pw.println("<h1>get Auth Mode::"+req.getAuthType()+"</h1>");
	pw.println("<h1>get user Name::"+req.getRemoteUser()+"</h1>");
}

}
