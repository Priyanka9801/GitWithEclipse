package Serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register2.cdac")
public class RegisterServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int mobileNo = Integer.parseInt(request.getParameter("mobileNo"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		out.write("<html><body>");

		RegisterService registerService = new RegisterService();
		boolean present = registerService.isCustomerPresent(email);
		if(present) {
			out.write("<h1>It seems you are already a registered user!</h1>");
		}
		else {
			registerService.register(name, email, mobileNo, username, password);
			out.write("<h1>Registration successful!</h1>");
		}

		out.write("</body></html>");
	}

}
