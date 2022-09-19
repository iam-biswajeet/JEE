package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "emp", urlPatterns = "/empurl", initParams = {
		@WebInitParam(name = "driver", value = "oracle.jdbc.driver.OracleDriver"),
		@WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
		@WebInitParam(name = "user", value = "c##biswajit"), @WebInitParam(name = "password", value = "2538") })
public class EmployeeSearchServletByEmployeeId extends HttpServlet {
	private final String EMP_SEARCH_BY_EID = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GEt printWriter
		PrintWriter pw = resp.getWriter();
		// Set ContenTyoe
		resp.setContentType("text/html");
		RequestDispatcher rd1=req.getRequestDispatcher("/headerurl");
		rd1.include(req,resp);
		ServletConfig cg = super.getServletConfig();

		String driver = cg.getInitParameter("driver");
		String url = cg.getInitParameter("url");
		String user = cg.getInitParameter("user");
		String pwd = cg.getInitParameter("password");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement ps = con.prepareStatement(EMP_SEARCH_BY_EID);

		) {

			if (ps != null) {
				int eno = Integer.parseInt(req.getParameter("eid"));
				ps.setInt(1, eno);
			}
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					pw.println("<h1 style='color:green; text-align:center'>Employee Details</h1>");
					pw.println("<h2 style='color:green;text-align:center'>Employee NO::" + rs.getInt(1) + "</h2>");
					pw.println("<h2 style='color:green;text-align:center'>Employee Name::" + rs.getString(2) + "</h2>");
					pw.println("<h2 style='color:green;text-align:center'>Employee Job::" + rs.getString(3) + "</h2>");
					pw.println(
							"<h2 style='color:green;text-align:center'>Employee Salary::" + rs.getFloat(4) + "</h2>");

				} else {
					pw.println("<h1 style='color:Red; text-align:center'>Employee Not AVailable </h1>");
				}
				
				
				
				RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
				rd2.include(req, resp);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			pw.println("before  rd.foreword() sattement");
			System.out.println("Before rd.forward()");
			ServletContext sc = super.getServletContext();
			/*
			 * RequestDispatcher rd=req.getRequestDispatcher("/errorurl"); ServletContext
			 * sc=super.getServletContext(); RequestDispatcher
			 * rd=sc.getRequestDispatcher("errorurl");
			 * 
			 * RequestDispatcher rd=sc.getNamedDispatcher("error");
			 */
			//RequestDispatcher rd=req.getRequestDispatcher("error.html")
			RequestDispatcher rd3=sc.getNamedDispatcher("err");
			rd3.forward(req, resp);
			pw.println("after  rd.foreword() sattement");
			System.out.println("after rd.forward()");
			// rd.forward(req, resp);
		}
		pw.println("<h2 style='text-align:center'><a  href='employee_search.html'>Home</a></h2>");
		pw.close();
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
