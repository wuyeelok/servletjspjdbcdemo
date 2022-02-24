package com.kenneth.wu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		Statement stmt = null;
		PreparedStatement p = null;
		Statement stmt2 = null;

		List<EMP1> employeeList = null;

		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			isConnectDB = true;

			// Create a table in DB
			stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION " + "(id INTEGER NOT NULL AUTO_INCREMENT, "
					+ " first VARCHAR(255), " + "last VARCHAR(255), " + "age INTEGER, " + " PRIMARY KEY(id))";

			stmt.executeUpdate(sql);

			// Add data in the table
			String insertRegSQL = "INSERT INTO REGISTRATION (first, last, age) " + " VALUES(?, ?, ?)";

			p = conn.prepareStatement(insertRegSQL);
			p.setString(1, "ABC");
			p.setString(2, "DEF");
			p.setInt(3, 35);

			p.executeUpdate();

			// Print data from the table
			stmt2 = conn.createStatement();

			String sql3 = "SELECT id, first, last, age from REGISTRATION";
			ResultSet rs = stmt2.executeQuery(sql3);

			employeeList = new ArrayList<>();

			while (rs.next()) {

				int id = rs.getInt("id");
				int age = rs.getInt("age");
				String first = rs.getString("first");
				String last = rs.getNString("last");

				EMP1 emp1 = new EMP1(id, age, first, last);
				employeeList.add(emp1);

			}

			// Clean up environment
			rs.close();

		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Fail to connect to DB or SQL not correct");
			e.printStackTrace();
		} finally {
			// Close resources

			try {
				if (stmt != null) {
					stmt.close();
				}
				if (stmt2 != null) {
					stmt2.close();
				}
				if (p != null) {
					p.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		response.getWriter().append("Served at: ").append(request.getContextPath()).append("Connect to DB? -> ")
				.append(String.valueOf(isConnectDB)).append("\n").append(this.printEmp1(employeeList));
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

	private String printEmp1(List<EMP1> employees) {
		StringBuilder sb = new StringBuilder("EMP1 list:\n");

		if (employees != null) {
			for (EMP1 emp1 : employees) {
				sb.append("ID: " + emp1.getId() + ", Age: " + emp1.getAge() + ", First Name: " + emp1.getFirst()
						+ ", Last Name: " + emp1.getLast() + "\n");
			}
		}

		return sb.toString();
	}
}
