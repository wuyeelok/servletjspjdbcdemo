package edureka1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String uName = request.getParameter("userName");
		String pWord = request.getParameter("userPassword");

		PrintWriter pw = response.getWriter();

		if ("edureka".equals(uName) && "edureka".equals(pWord)) {
			pw.println("Success Login!");
		} else {
			pw.println("Failed Login!");
		}

		pw.close();
	}

}
