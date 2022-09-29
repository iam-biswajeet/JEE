package com.nt.listner;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
@WebListener
public class RequestAnalyserListener implements ServletRequestListener {
	private long start,end;
	public RequestAnalyserListener() {
		System.out.println("RequestAnalyserListner.RequestAnalyserListner()");
	}
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestAnalyserListener.requestInitialized()");
		start=System.currentTimeMillis();
	}
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestAnalyserListener.requestDestroyed()");
		end=System.currentTimeMillis();
		HttpServletRequest req=(HttpServletRequest)sre.getServletRequest();
		ServletContext sc=req.getServletContext();;
		sc.log("total time taken to request::"+req.getRequestURI()+"  is "+(end-start));
		System.out.println("total time taken to request::"+req.getRequestURI()+"  is "+(end-start));
	}

}
