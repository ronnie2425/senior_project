package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controllers.LoginController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*Quarantine for errors*/
//TODO update with business variables

public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.getRequestDispatcher("/_view/signUp.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
        String errorMessage = null;
        Boolean result = null;
        try {
          String user = getStringFromParameter(req.getParameter("Username"));
          String email = getStringFromParameter(req.getParameter("Email address"));
          String pass = getStringFromParameter(req.getParameter("Password"));
          String cpass = getStringFromParameter(req.getParameter("Confirm Password"));
          String business = getStringFromParameter(req.getParameter("Business Name"));
          String hasBusiness = req.getParameter("BusinessCheck");



          if (user == null || email == null || pass == null || cpass == null /*|| (hasBusiness && business == null)*/) {//TODO repopulate fields and redisplay
            errorMessage = "Please fill in all fields.";
            req.setAttribute("errorMessage", hasBusiness);
            req.setAttribute("Username", user);
            req.setAttribute("Email address", email);
            req.setAttribute("Business Name", business);
            req.getRequestDispatcher("/_view/signUp.jsp").forward(req, resp);
          }
          
          if(!pass.equals(cpass)){
        	  errorMessage = "Passwords do not match.";
        	  req.setAttribute("errorMessage", errorMessage);
        	  
        	  
        	  req.getRequestDispatcher("/_view/signUp.jsp").forward(req, resp);
          }
          else { //creds acceptable, submit and redirect to login
            LoginController controller = new LoginController();
            result = controller.addNewAccount(user, pass, email);
            req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
          }
        } catch(Exception e) {
          errorMessage = "Something went worng in the SignUpServlet :(";
          req.setAttribute("errorMessage", errorMessage);
        }
        
        
        
	}//end doPost
	
	
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}//end parse string args
	
}//end class


/*end quarantine*/