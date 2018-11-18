package servlets;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import controllers.*;
import database.Databasequeries;



@WebServlet("/businessListServlet")
public class BusinessListServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		User user = (User) req.getSession().getAttribute("username");
//		//if the user is not logged in send to login page
//		if (user == null){
//			req.getRequestDispatcher("login.jsp").forward(req, resp);
//		}
//		//if the user is logged in send to feed page
//		else{
//			req.getRequestDispatcher("feed.jsp").forward(req, resp);
//	//String username = req.getSession().getAttribute("user").toString();
//		
//		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            		Databasequeries queries = new Databasequeries();
			
			
				List<Business> list=null;
			
					try {
						list = queries.findAllBusinesses();
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					
				
				req.setAttribute("businessList", list);
				
				
				req.getRequestDispatcher("businessList.jsp").forward(req, resp);
				}
			
				
				
				
				


		
	}
	


