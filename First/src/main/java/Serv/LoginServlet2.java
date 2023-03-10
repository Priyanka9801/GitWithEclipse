package Serv;
import Serv.LoginService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login2.cdac")
public class LoginServlet2 extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
	  String username = request.getParameter("username");
	  String password = request.getParameter("password");
	  
	  LoginService loginservice = new LoginService();
	  boolean isValid = loginservice.loginCheck(username,password);
	  
	  if(isValid) {
		  String rememberMe = request.getParameter("rememberMe");
		  if(rememberMe!=null&&rememberMe.equals("yes")) {
			  Cookie c1 = new Cookie ("uname", username);
			  c1.setMaxAge(60*60*24);
			  Cookie c2 = new Cookie("upass", password);
			  c2.setMaxAge(60 * 60 * 24);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			response.sendRedirect("welcome.html");
		}
		else
			response.sendRedirect("login.html");
		
	}

}
		