package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.wrapper.CustomRequest;
import com.nt.wrapper.CustomResponse;

@WebFilter("/loginurl")
public class LoginFilter extends javax.servlet.http.HttpFilter {
	public LoginFilter() {
		System.out.println("LoginFilter.LoginFilter()");
	}
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		CustomRequest creq=new CustomRequest(req);
		CustomResponse cres=new CustomResponse(res);
		chain.doFilter(creq,cres);
		String output=cres.toString();
		output=output+"<h1>Naresh It</h1>";
		PrintWriter pw=res.getWriter();
		pw.println(output);
		pw.close();
		
	}
	
	
	

}
