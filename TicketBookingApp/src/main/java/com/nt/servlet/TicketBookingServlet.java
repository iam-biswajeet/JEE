package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tktbookingurl")
public class TicketBookingServlet extends HttpServlet {
	public TicketBookingServlet() {
		System.out.println("TicketBookingServlet.TicketBookingServlet()");
	}

	int count = 0;
	Connection con = null;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##biswajit", "2538");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/plain");
		//Read the form data
		String pname=req.getParameter("pname");
		String addrs=req.getParameter("paddrs");
		try(Statement st=con.createStatement()){
			synchronized(con) {
			pw.println("<h1 style='color:red;text-align:center'>No of booking available::"+(5-count)+"</h1>");
			//Thread.sleep(20000);
			
			if(count<5) {
			st.executeUpdate("INSERT INTO TKT_BOOKING VALUES(MY_SEQ.NEXTVAL,'"+pname+"','"+addrs+"')");
			count++;
			pw.println("<h1 style='color:red;text-align:center'>Your booking Successful</h1>");
			}
			else {
				pw.println("<h1 style='color:red;text-align:center'>No More Booking</h1>");
			}
			
		}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
