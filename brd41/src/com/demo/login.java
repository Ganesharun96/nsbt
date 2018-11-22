package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("login")
public class login extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		if(validateLogin(loginId, password) )
		{
			//response.sendRedirect("Products.jsp");
			response.sendRedirect("https://www.google.com");
		}
		else
		{
			response.sendRedirect("LoginError.jsp");
		}
	}

	private boolean validateLogin(String loginId, String password) {
		try {
			// Load the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Get a connection
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			// Create a statement
			Statement statement = connection.createStatement();
			// Execute a Query
			String query = "select count(loginid) from users where loginid ='" + loginId +"' and password ='"+ password +"'";
			System.out.println(query);
			ResultSet loginResult = statement.executeQuery(query);
			// Iterate through the result set and display the records.
			System.out.println("Valid Login!");
			//System.out.println(loginResult.getInt(1));
			if (loginResult.next()) {
				if(loginResult.getInt(1) > 0)
				return true;
			}

		} catch (ClassNotFoundException exception) {
			System.out.println(exception);
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		return false;
	}
}

