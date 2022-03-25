package com.zoho;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zoho.proto.Student;

/**
 * Servlet implementation class AddRecord
 */
@WebServlet("/addrecord")
public class AddRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		System.out.println("doGet call here");
		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setRollno(Long.valueOf(request.getParameter("rollno")));
		student.setEmail(request.getParameter("email"));
		student.setPhone(Long.valueOf(request.getParameter("phone")));
		student.setCountry(request.getParameter("country"));
		student.setDob(request.getParameter("dob"));
		
		
		//Insert in DB
		Boolean status = insertValues(student);
		
		PrintWriter out = response.getWriter();
	    out.println("Record insert - "+status);
		
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
   
   
   
	   
   public Boolean insertValues(Student student)
   {
	   System.out.println("Insert valyes method called here");
        Connection connect = connectDB();
        
        try 
        {
	        String query = "insert into ZUStudents values (?,?,?,?,?,?)";
	        PreparedStatement preparedStatement = connect.prepareStatement(query);
	        
	        preparedStatement.setLong(1, student.rollno);
	        preparedStatement.setString(2, student.getName());
	        preparedStatement.setString(3, student.email);
	        preparedStatement.setLong(4, student.phone);
	        preparedStatement.setString(5, student.dob);	        
			preparedStatement.setString(6, student.country);

	        preparedStatement.executeUpdate();
	        
	        connect.close();
	        
	        System.out.println("Insert successful");
	        return true;
		} catch (SQLException e) {
			System.out.println("Insert failure");
			e.printStackTrace();
			return false;
		}
        
   }

}
