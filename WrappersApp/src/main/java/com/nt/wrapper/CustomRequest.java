package com.nt.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomRequest extends HttpServletRequestWrapper {
	HttpServletRequest req;
	public CustomRequest(HttpServletRequest req) {
		super(req);
		System.out.println("CustomRequest.CustomRequest()");
		this.req=req;
	}
	@Override
	public String getParameter(String name) {
		String paramVal=req.getParameter(name);
		if(name.equalsIgnoreCase("email")) {
			if(!(paramVal.endsWith("@gmail.com"))) {
				paramVal=paramVal+"@gmail.com";
			}
		}
		return paramVal;
	}
	

}
