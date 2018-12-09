package servlets;

import java.io.IOException;
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




@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet{
	
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
		
		if (username!=null){
			EventController controller = new EventController();
			List<Business> b;
			BusinessController bc = new BusinessController();
				b = bc.findSubscribedBusiness(username);
				b.addAll(bc.findSubscribedBusiness(username));
				if(b.isEmpty()) {
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}
				List<Event> list=controller.findEventByBusiness(b.get(0).getName());
			for(int i=1; i< (b.size());i++) {
				list.addAll(controller.findEventByBusiness(b.get(0).getName()));
			}
				Collections.sort(list);
			
			req.setAttribute("list", list);
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
				User user=null;
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
            	if (username!=null){			
				EventController controller = new EventController();
				List<Business> b;
				BusinessController bc = new BusinessController();
				b = bc.findSubscribedBusiness(username);
				if (!b.isEmpty()) {
					List<Event> list=controller.findEventByBusiness(b.get(0).getName());
					for(int i=1; i< (b.size());i++) {
						list.addAll(controller.findEventByBusiness(b.get(0).getName()));
				}
				Collections.sort(list);
				
				req.setAttribute("list", list);
					}

				req.getRequestDispatcher("index.jsp").forward(req, resp);
				}
				
				
            	req.getRequestDispatcher("index.jsp").forward(req, resp);
				
				


		
	}
	}


