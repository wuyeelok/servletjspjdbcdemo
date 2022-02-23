package com.kenneth.wu;

import java.io.IOException;
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

		Boolean isClassFound = false;
		try {
			Class.forName(JDBC_DRIVER);
			isClassFound = true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("Class is found? ->")
				.append(String.valueOf(isClassFound));
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
