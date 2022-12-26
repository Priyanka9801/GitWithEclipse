package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register.cdac")
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobileNo = request.getParameter("mobileNo");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/cdac", "root", "priyanka");
			PreparedStatement st = conn.prepareStatement("insert into customer(name, email, mobileno, username, password) values(?, ?, ?, ?, ?)");
			st.setString(1, name); //substituting ? with actual value
			st.setString(2, email);
			st.setString(3, mobileNo);
			st.setString(4, username);
			st.setString(5, password);
			st.executeUpdate();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.write("<html><body>");
		out.write("<h1>Registration successful!</h1>");
		out.write("</body></html>");
	}

}
