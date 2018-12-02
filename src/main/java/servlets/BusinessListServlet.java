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
		else {
			Databasequeries queries = new Databasequeries();
			
			
			List<Business> list=null;
		
				try {
					list = queries.findAllBusinesses();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
			
			req.setAttribute("list", list);
			
			
			req.getRequestDispatcher("businessList.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
            		Databasequeries queries = new Databasequeries();
//			
//			
//				List<Business> list=null;
//			
//					try {
//						list = queries.findAllBusinesses();
//					} catch (URISyntaxException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				
//					
//				
//				req.setAttribute("list", list);
//				
//				
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
				String b_name=req.getAttribute("businessName").toString();
				if (b_name!=null) {
					try {
						queries.insertRelation(username, b_name);
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				req.getRequestDispatcher("businessListServlet").forward(req, resp);
				}
			
				
				
				
				


		
	}
	


