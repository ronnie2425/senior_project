package servlets;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;

import controllers.LoginController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/*Quarantine for errors*/
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
        String errorMessage = null;
        
        try {
          String user = getStringFromParameter(req.getParameter("Username"));
          String pass = getStringFromParameter(req.getParameter("Password"));

          if (user == null || pass == null) {
            errorMessage = "Please fill in all fields.";
            req.setAttribute("errorMessage", errorMessage);
          }
          else { //fields filled
            LoginController controller = new LoginController();
            pass = controller.gimmeSalt(pass);
            pass = controller.hashBrowns(pass);
            
           // if(controller.verifyAccount(user, pass)){
            if (true) {
            	//resp.sendRedirect(req.getContextPath() + "/businessList.jsp");
            	req.getRequestDispatcher("index.jsp").forward(req, resp);	//TODO UserHome.jsp
            }//end good login
            else {//bad creds
            	errorMessage = "Invalid login.";
            	req.setAttribute("errorMessage", errorMessage);
            }//end bad creds else
            
          }//end fields filled else
          
        } catch(Exception e) {
          errorMessage = "There was a problem in the LoginServlet.";
          req.setAttribute("errorMessage", errorMessage);
        }
        
        //display
        req.getRequestDispatcher("login.jsp").forward(req, resp);
        
	}//end doPost
	
	
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}//end parse string args
	
}//end class

