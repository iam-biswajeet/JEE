package com.nt.listner;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionAnalyserListener implements HttpSessionListener {
	private long start,end;
	public SessionAnalyserListener() {
		System.out.println("SessionAnalyserListener.SessionAnalyserListener()");
	
	}
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("SessionAnalyserListener.sessionCreated()");
		start=System.currentTimeMillis();
		Date d=new Date(start);
		System.out.println("session start at::"+d);
		ServletContext sc=se.getSession().getServletContext();
		sc.log("session start at::"+d);
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("SessionAnalyserListener.sessionDestroyed()");
		end=System.currentTimeMillis();
		Date d=new Date(end);
		System.out.println("session end at::"+d);
		ServletContext sc=se.getSession().getServletContext();
		sc.log("session end at::"+d);
		System.out.println("session duration::"+(end-start));
	}

}
