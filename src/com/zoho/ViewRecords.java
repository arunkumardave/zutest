package com.zoho;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zoho.proto.Student;

/**
 * Servlet implementation class ViewRecords
 */
@WebServlet("/viewstudents")
public class ViewRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		
	}


	   public Boolean fetchValues(Student student)
	   {
		   System.out.println("Fetch valyes method called here");
	        Connection connect = connectDB();
	        
	        try 
	        {
		        String query = "select * from ZUStudents";
		        PreparedStatement preparedStatement = connect.prepareStatement(query);
		        

		        ResultSet result = preparedStatement.executeQuery();
		        
		        
		        System.out.println("Insert successful");
		        return true;
			} catch (SQLException e) {
				System.out.println("Insert failure");
				e.printStackTrace();
				return false;
			}
	        
	   }

	
	   public static Connection connectDB()
	    {
		   System.out.println("connectDB method called here");
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zutestdb", "root", "");
	        }
	        catch (Exception message) {
	            System.out.println(message);
	        }
	        return connection;
	    }
	   
	   

}
