package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;
import controllers.*;




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
			BusinessController bc=new BusinessController();
			
			List<Business> list=null;
			list = bc.findAllBusinesses();
			req.setAttribute("list", list);
			req.getRequestDispatcher("businessList.jsp").forward(req, resp);
		}
	}
	
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
            		BusinessController bc= new BusinessController();
				String b_name=req.getParameter("bn");
				if (b_name!=null) {
					bc.unsubscribe(username, b_name);
					bc.subscribe(username, b_name);
					
				}
				req.getRequestDispatcher("businessList.jsp").forward(req, resp);
				}
			
				
				
				
				


		
	}
	


