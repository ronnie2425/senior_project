package servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.*;
import model.*;


public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		
		LoginController controller = new LoginController();
		//controller.setModel(user);
		
		
		
		//check if input username and password exist
		if (req.getParameter("Username") != null && req.getParameter("Password") != null){
			System.out.println("username and password fields found " + username +" " + password);
			boolean login = controller.verifyAccount(username, password);
			
			//if the username and password match credentials in the database then login
//			//if (login){
//				System.out.println("the database returned the password:" + user.getPassword());
//				System.out.println("the database returned the username:" + user.getUsername());
//			
//				req.getSession().setAttribute("user", user);	
//				req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
//			}
//			else if (!login){
//				//login failed
//				req.setAttribute("error", "Invalid username/password");
//				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
//			}
//		}
		
		else{
			System.out.println("Invalid username and/or password");
			//return to login if login fails
			req.setAttribute("error", "Invalid username/password");
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}		
	}

