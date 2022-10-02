package com.nt.wrapper;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomResponse extends HttpServletResponseWrapper {
	HttpServletResponse response;
	CharArrayWriter writer=null;
	public CustomResponse(HttpServletResponse response) {
		super(response);
		System.out.println("CustomResponse.CustomResponse()");
		this.response=response;
		writer=new CharArrayWriter();
	
	}
	@Override
	public PrintWriter getWriter() throws IOException {
		System.out.println("CustomResponse.getWriter()");
		
		PrintWriter pw= new PrintWriter(writer);
		return pw;
	}
	@Override
	public String toString() {
		System.out.println("CustomResponse.toString()");
		return writer.toString();
	}
	

}
