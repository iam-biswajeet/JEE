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
public class PerfermanceTestFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("PerfermanceTestFilter.doFilter()");
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		long start=0l,end=0l;
		start=System.currentTimeMillis();
		chain.doFilter(req,res);
		end=System.currentTimeMillis();
		System.out.println("request processing time::"+(end-start)+"  ms");
	}

}
