package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BusinessController;
import controllers.EventController;
import model.Business;
import model.Event;


//Quarantine for errors

@WebServlet("/editEventServlet")
public class EditEventServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	EventController event_controller = new EventController();
    BusinessController bus_control = new BusinessController();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			//get username from cookie
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
			}//end cookie authentication
			//if the user is not logged in send to login page
			if (username == null){
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
			
			//retrieve list of bussiness options to pick from
			List<Business> businessNames = bus_control.findBusinessByOwner(username);
			
			String error=req.getParameter("eventId");
			req.setAttribute("errorMessage", error);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			
			Event eventData = event_controller.findByID(getIntFromParameter(req.getParameter("eventId")));

			//set attributes to jsp
			List<Event> list=new ArrayList<Event>();
			list.add(eventData);
			req.setAttribute("list", list);
			req.setAttribute("BusinessList", businessNames);
			req.getRequestDispatcher("editEvent.jsp").forward(req, resp);
			
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		// Decode form parameters and dispatch to event_controller
        String errorMessage = null;
        errorMessage = "DEBUG: failed at start";
	    String name = req.getParameter("Name");
	    String description = req.getParameter("Description");
	    String start1 = req.getParameter("Start");
	    String end1 = req.getParameter("End");
	    String datestart1 = req.getParameter("Start Date");
	    String dateEnd1 = req.getParameter("End Date");
	    String businessName = req.getParameter("business");	
	    String location = req.getParameter("Location");
        errorMessage = "DEBUG: failure between time and parameters";
        
        try {
          String array[]=datestart1.split("-");
		  String array1[]=start1.split(":");
		  Calendar start = Calendar.getInstance();
		  start.set(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array1[0]), Integer.parseInt(array1[1]), Integer.parseInt(array1[2]));
          String array2[]=dateEnd1.split("-");
		  String array3[]=end1.split(":");
		  Calendar end = Calendar.getInstance();
		  end.set(Integer.parseInt(array2[0]), Integer.parseInt(array2[1]), Integer.parseInt(array2[2]), Integer.parseInt(array3[0]), Integer.parseInt(array3[1]), Integer.parseInt(array3[2]));
   
          String username=null;
  		Cookie[] cks=req.getCookies();
  		if (cks !=null){
  			for (int i=0;i<cks.length;i++){
  				String uname=cks[i].getName();
  				username = cks[i].getValue();
  				if (uname.equals("auth")){
  					break;
  				}
  			}
  		}
  		if (username == null){
  			req.getRequestDispatcher("login.jsp").forward(req, resp);
  		}
    			

          if (name == null || location == null || start == null || end == null) { 
            errorMessage = "Please fill in the event's name, start date, and end date.";
            
            //save info
            req.setAttribute("Event name", name);
            req.setAttribute("Event details", description);
            req.setAttribute("Start date", start);
            req.setAttribute("End date", end);
            req.setAttribute("Location", location);
            req.setAttribute("errorMessage", errorMessage);
            
            //reload
            req.getRequestDispatcher("newEvent.jsp").forward(req, resp);
          }
          
          else { //fields filled
            if(event_controller.AddEvent(name, description, start.getTimeInMillis(), end.getTimeInMillis(), businessName, location)){
        
            	req.getRequestDispatcher("index.jsp").forward(req, resp); //TODO Change to event.jsp
            
            }//end saves properly
            else{

                //display the event
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
            
          }//end else
          
        }//end try
        catch(Exception e) {
          req.setAttribute("errorMessage", errorMessage);
          
          //display the event
          req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        

	}//end doPost
	
	
	private int getIntFromParameter(String s) {
		if (s == null || s.equals("")) {
			return -1;
		} else {
			return Integer.parseInt(s);
		}
	}//end parse int args
	
}//end class


//end quarantine