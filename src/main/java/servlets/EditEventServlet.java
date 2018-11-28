package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.EventController;
import model.Business;
import model.Event;
import model.User;


//Quarantine for errors

@WebServlet("/editEventServlet")
public class EditEventServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.getRequestDispatcher("/_view/editEvent.jsp").forward(req, resp);
	}
	
	
	protected void doPostGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = getIntFromParameter(req.getParameter("ID"));
		
		EventController controller = new EventController();
		Event oldInfo = controller.findByID(12);
		
		String name = oldInfo.getName();
        String description = oldInfo.getDescription();
        int start = oldInfo.getStart();
        int end = oldInfo.getEndDate();
        int time = oldInfo.getTime();
        String businessName = oldInfo.getBusiness();
        String location = oldInfo.getLocation();
        String errorMessage = "";
        
        req.setAttribute("Event name", name);
        req.setAttribute("Event details", description);
        req.setAttribute("Start time", start);
        req.setAttribute("End time", end);
        req.setAttribute("date", time);
        req.setAttribute("Business", businessName);
        req.setAttribute("Location", location);
        req.setAttribute("errorMessage", errorMessage);
        req.setAttribute("ID", id);
        
    	//display the event
    	req.getRequestDispatcher("/_view/editEvent.jsp").forward(req, resp);
		
		
	}//end get event info
	
	
	protected void doPostSet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
		/*if(req.getParameter("Username") != null){
		resp.sendRedirect(req.getContextPath() + "/UserHome");
		}*/
		
		// Decode form parameters and dispatch to controller
        String errorMessage = null;
        try {
          String name = getStringFromParameter(req.getParameter("Event name"));
          String description = getStringFromParameter(req.getParameter("Event details"));
          int start = getIntFromParameter(req.getParameter("Start date"));
          int end = getIntFromParameter(req.getParameter("End date"));
          int time = getIntFromParameter(req.getParameter("Time"));
          String businessName = getStringFromParameter(req.getParameter("Business"));	//May not work
          String location = getStringFromParameter(req.getParameter("Location"));
          int id = getIntFromParameter(req.getParameter("ID"));
          
          /*if(req.getSession().getAttribute("username") != null){
  			String username = (String) req.getSession().getAttribute("username");
  		  }
          else{
          		//req.getSession().setAttribute("username", "guest");
          }*/


          if (name == null || location == null || start < 1010001 || end < 1010001) { // (01-01-0001) the first day.
            errorMessage = "Please fill in the event's name, start date, and end date.";
            
            //save info
            req.setAttribute("Event name", name);
            req.setAttribute("Event details", description);
            req.setAttribute("Start date", start);
            req.setAttribute("End date", end);
            req.setAttribute("Business", businessName);
            req.setAttribute("Location", location);
            req.setAttribute("errorMessage", errorMessage);
            req.setAttribute("ID", id);
            
            //reload
            req.getRequestDispatcher("/_view/editEvent.jsp").forward(req, resp);
          }
          
          else { //fields filled
            EventController controller = new EventController();
            if(controller.editEvent(id, name, description, start, end, time, businessName, location)){
            	//set new attributes to display
            	req.setAttribute("Event name", name);
                req.setAttribute("Event details", description);
                req.setAttribute("Start date", start);
                req.setAttribute("End date", end);
                req.setAttribute("Business", businessName);
                req.setAttribute("Location", location);
                req.setAttribute("errorMessage", errorMessage);
                req.setAttribute("ID", id);
                
            	//display the event
            	req.getRequestDispatcher("/_view/event.jsp").forward(req, resp);
            
            }//end saves properly
            else{
            	//TODO: goto catch
            	errorMessage = "Something went worng in the EditEventServlet :(";
                //set new attributes to display
                req.setAttribute("errorMessage", errorMessage);
                
                //display the event
                req.getRequestDispatcher("/_view/event.jsp").forward(req, resp);	//update
            }
            
          }//end else
          
        }//end try
        catch(Exception e) {
          errorMessage = "Something went worng in the EditEventServlet :(";
          //set new attributes to display
          req.setAttribute("errorMessage", errorMessage);
          
          //display the event
          req.getRequestDispatcher("/_view/event.jsp").forward(req, resp);		//update
        }
        

	}//end modify event info
	
	
	private String getStringFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return s;
		}
	}//end parse string args
	
	private int getIntFromParameter(String s) {
		if (s == null || s.equals("")) {
			return -1;
		} else {
			return Integer.parseInt(s);
		}
	}//end parse int args
	
}//end class


//end quarantine