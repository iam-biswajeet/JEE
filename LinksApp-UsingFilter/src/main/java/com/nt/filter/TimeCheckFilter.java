package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class TimeCheckFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("TimeCheckFilter.doFilter()");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		LocalDateTime ldt=LocalDateTime.now();
		int hour=ldt.getHour();
		if(hour>9 && hour<17) {
			chain.doFilter(req,res);
		}
		else {
			pw.println("<h1>Request Can send only between 5:00 AM to 9:00PM</h1>");
		}
	}
	

}
