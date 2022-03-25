//$Id$
package com.zoho;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{

	
	public void init(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String message = "init-Hello1";
	      PrintWriter out = response.getWriter();
	      out.println( message);
	   }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String url = request.getServletPath();
		
		String message = "Hello. This is servlet, ULR : "+url;
		
	      PrintWriter out = response.getWriter();
	      out.println( message);
	      
	}
	  	
	
}
