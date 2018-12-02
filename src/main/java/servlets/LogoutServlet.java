package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//remove the user
			    Cookie[] cookies = req.getCookies();
			    if (cookies != null) {
			       for (Cookie cookie : cookies) {
			          if(cookie.getName().equals(req.getSession().getAttribute("auth"))) {
			                     System.out.println(req.getSession().getAttribute("auth")
			                        + cookie.getValue());
			            }
			            cookie.setMaxAge(0);
			            resp.addCookie(cookie);
			         }
			    }
				//return to index
				req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//remove the user
//		//req.getSession().removeAttribute("user");
//	    Cookie[] cookies = req.getCookies();
//	    if (cookies != null) {
//	       for (Cookie cookie : cookies) {
//	          if(cookie.getName().equals(req.getSession().getAttribute("auth"))) {
//	                     System.out.println(req.getSession().getAttribute("auth")
//	                        + cookie.getValue());
//	            }
//	            cookie.setMaxAge(0);
//	            resp.addCookie(cookie);
//	         }
//	    }
//		//return to index
//		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
