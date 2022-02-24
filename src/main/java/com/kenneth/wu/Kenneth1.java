package com.kenneth.wu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Kenneth1
 */
public class Kenneth1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/employee?useSSL=false";
	static final String USER = "edureka";
	static final String PASSWORD = "edureka";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Kenneth1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Boolean isConnectDB = false;
		Connection conn = null;

		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			isConnectDB = true;
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Fail to connect to DB");
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("Connect to DB? -> ")
				.append(String.valueOf(isConnectDB));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
