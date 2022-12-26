package Serv;


public class LoginService{
	
	
		public boolean loginCheck(String username, String password) {
			if(username.equals("priyanka") && password.equals("123"))
				return true;
			return false;
		}

	}
