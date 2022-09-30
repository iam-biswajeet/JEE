package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class BrowserCheckFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("BrowserCheckFilter.doFilter()");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String browser=req.getHeader("user-agent");
		System.out.println(browser);
		if(browser.contains("Chrome")) {
			chain.doFilter(req, res);
		}
		else {
			pw.println("<h1>The Request can only send from chrome</h1>");
		}
		
	}

}
