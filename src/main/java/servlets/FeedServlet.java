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



@WebServlet("/feedServlet")
public class FeedServlet extends HttpServlet{
	
private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("username");
		//if the user is not logged in send to login page
		if (user == null){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		//if the user is logged in send to feed page
		else{
			req.getRequestDispatcher("feed.jsp").forward(req, resp);
	//String username = req.getSession().getAttribute("user").toString();
		
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
	
				//User user = (User) req.getSession().getAttribute("user");
				//String[] businesses= {"Test1","Test2","Test3"}; 
				
				//User user=new User ("TESTER","PASSWORD", "EMAIL",businesses );
				//LoginController log = new LoginController();
				User user=null;
				String username=null;
				//String username=req.getSession().getAttribute("username").toString();
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
				
				
				//String errorMessage = username;
            	//req.getSession().setAttribute("user", null);
            	//errorMessage = "Session terminated, please log in again.";
            	//req.setAttribute("errorMessage", errorMessage);
            	//req.getRequestDispatcher("login.jsp").forward(req, resp);
            	if (username!=null){
//				try {
//					//user = log.findAccountByName(username).get(0);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
            		Databasequeries queries = new Databasequeries();
			
				EventController controller = new EventController();
				List<Business> b;
				try {
					b = queries.findBusinesssFromAccount(username);
					List<Event> list=controller.findEventByBusiness(b.get(0).getName());
				for(int i=1; i< (b.size());i++) {
					list.addAll(controller.findEventByBusiness(b.get(0).getName()));
				}
					Collections.sort(list);
				
				req.setAttribute("list", list);
				
				
				req.getRequestDispatcher("feed.jsp").forward(req, resp);
				}
				 catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				
				


		
	}
	}


