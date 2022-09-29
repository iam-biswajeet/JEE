package com.nt.listner;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class WebAppMoniterListener implements ServletContextListener {
	private long start,end;
	public WebAppMoniterListener() {
		System.out.println("WebAppMoniterListener.WebAppMoniterListener()");
	}
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebAppMoniterListener.contextInitialized()");
		start=System.currentTimeMillis();
		Date d=new Date(start);
		System.out.println("Web app deployee Time::"+d);
		ServletContext sc=sce.getServletContext();
		sc.log("Web app deployee Time::"+d);
	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebAppMoniterListener.contextDestroyed()");
		end=System.currentTimeMillis();
		Date d=new Date(end);
		System.out.println("Web app undeployee/"+d);
		ServletContext sc=sce.getServletContext();
		sc.log("Web app undeployee Time::"+d);
		
	}

}
