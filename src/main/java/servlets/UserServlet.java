package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*Quarantine for errors*/

public class UserServlet extends HttpServlet {

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
        	if(req.getSession().getAttribute("username") != null){
      			String username = (String) req.getSession().getAttribute("username");
      			req.setAttribute("Username", username);
      		}
            else{
            	errorMessage = "Attempted to access your homepage without a logged in user.";
            	req.setAttribute("errorMessage", errorMessage);
            	req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
            }
        	
            
          
        }//end try
        catch(Exception e) {
        	errorMessage = "Something went worng in the UserServlet :(";
        	req.setAttribute("errorMessage", errorMessage);
        	req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
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