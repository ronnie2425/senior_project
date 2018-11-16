package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.BusinessController;
import controllers.EventController;
import model.Business;
import model.User;


//Quarantine for errors

@WebServlet("/newEventServlet")
public class NewEventServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	EventController controller = new EventController();
    BusinessController bus_control = new BusinessController();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		req.getRequestDispatcher("newEvent.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
		/*if(req.getParameter("Username") != null){
		resp.sendRedirect(req.getContextPath() + "/UserHome");
		}*/
		
		// Decode form parameters and dispatch to controller
        String errorMessage = null;
        try {
        	errorMessage = "failed at start";
          String name = req.getParameter("Name");
          String description = req.getParameter("Description");
          String start1 = req.getParameter("Start");
          String end1 = req.getParameter("End");
          String time1 = req.getParameter("Time");
          String businessName = null;
          //req.getParameter("Business");	//May not work
          String location = req.getParameter("Location");
          errorMessage = "falure between time and parameters";
          String array[]=time1.split("-");
          int time= (Integer.parseInt(array[0])-2000) + (Integer.parseInt(array[2])*100) +(Integer.parseInt(array[0])*10000);
          String array1[]=start1.split(":");
          int start= (Integer.parseInt(array1[2])) + (Integer.parseInt(array1[1])*100) +(Integer.parseInt(array1[0])*10000);
          String array2[]=end1.split(":");
          int end= (Integer.parseInt(array2[2])) + (Integer.parseInt(array2[1])*100) +(Integer.parseInt(array2[0])*10000);
         
          errorMessage = "failed at first if";
          
          
          if(req.getSession().getAttribute("user") != null && req.getSession().getAttribute("user") != ""){
    			String user = (String) req.getSession().getAttribute("user");
    			businessName = bus_control.findBusinessByUser(user);
    		  }
            else{
            	errorMessage = "failed at else to first if";
            	req.getSession().setAttribute("user", null);
            	errorMessage = "Session terminated, please log in again.";
            	req.setAttribute("errorMessage", errorMessage);
            	req.getRequestDispatcher("login.jsp").forward(req, resp);
            }//end session data check


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
            
            //reload
            req.getRequestDispatcher("editEvent.jsp").forward(req, resp);
          }
          
          else { //fields filled
        	  errorMessage = "failed at eventController";
            EventController controller = new EventController();
            if(controller.AddEvent(name, description, start, end, time, businessName, location)){
            	//set new attributes to display
            	req.setAttribute("Event name", name);
                req.setAttribute("Event details", description);
                req.setAttribute("Start date", start);
                req.setAttribute("End date", end);
                req.setAttribute("Business", businessName);
                req.setAttribute("Location", location);
                req.setAttribute("errorMessage", errorMessage);
                            
            	//display the event
            	req.getRequestDispatcher("index.jsp").forward(req, resp); //TODO Change to event.jsp
            
            }//end saves properly
            else{
            	//TODO: goto catch
            	//errorMessage = "Something fucked up."; 				//TODO recheck this
                //set new attributes to display
                req.setAttribute("errorMessage", errorMessage);
                
                //display the event
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
            
          }//end else
          
        }//end try
        catch(Exception e) {
          //errorMessage = "Something went wrong in the NewEventServlet :(";
          //set new attributes to display
          req.setAttribute("errorMessage", errorMessage);
          
          //display the event
          req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        

	}//end doPost
	
	
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

