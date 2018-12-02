package servlets;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import controllers.BusinessController;
import controllers.LoginController;
import database.Databasequeries;
import model.Business;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*Quarantine for errors*/
//TODO update with business variables
@WebServlet("/newBusinessServlet")
public class NewBusinessServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=null;
		Cookie[] cks=req.getCookies();
		if (cks !=null){
			for (int i=0;i<cks.length;i++){
				String name=cks[i].getName();
				username = cks[i].getValue();
				if (name.equals("auth")){
					break;
				}
			}
		}
		//if the user is not logged in send to login page
		if (username == null){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			String username=null;
			Cookie[] cks=req.getCookies();
			if (cks !=null){
				for (int i=0;i<cks.length;i++){
					String name=cks[i].getName();
					username = cks[i].getValue();
					if (name.equals("auth")){
						break;
					}
				}
			}
			//if the user is not logged in send to login page
			if (username == null){
				req.getRequestDispatcher("login.jsp").forward(req, resp);
		}

          String business = req.getParameter("bname");
          String location = req.getParameter("blocation");
          String errorMessage = null;
          BusinessController bc=new BusinessController();
          
          if (business == null || location == null) {
              errorMessage = "Please fill in all fields.";
              req.setAttribute("errorMessage", errorMessage);
            }

          Business error=bc.findBusinessByName(business);
          if (error.equals(new Business())) {
        	  errorMessage = "Business Already exists";
              req.setAttribute("errorMessage", errorMessage);
          }
        	  bc.insertBusiness(business, location);
        	  Databasequeries db = new Databasequeries();
        	  try {
				db.removeRelation(username, business);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	  try {
				db.insertOwn(username,business);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			req.getRequestDispatcher("indexServlet").forward(req, resp);
			}
      
		}


