package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
			
			//retrieve list of bussiness options to pick from
			List<Business> businessNames = bus_control.findBusinessByOwner(username);
			
			//TODO: transmute data format?
			
			//set attribute to jsp
			req.setAttribute("BusinessList", businessNames);
			
			
			req.getRequestDispatcher("newEvent.jsp").forward(req, resp);
		}//end doGet

	@SuppressWarnings("deprecation")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
		/*if(req.getParameter("Username") != null){
		resp.sendRedirect(req.getContextPath() + "/UserHome");
		}*/
		
		// Decode form parameters and dispatch to controller
        String errorMessage = null;
        errorMessage = "DEBUG: failed at start";
	    String name = req.getParameter("Name");
	    String description = req.getParameter("Description");
	    String start1 = req.getParameter("Start");
	    String end1 = req.getParameter("End");
	    String datestart1 = req.getParameter("Start Date");
	    String dateEnd1 = req.getParameter("End Date");
	    String businessName = null;
	    //req.getParameter("Business");	//May not work
	    String location = "tetsiaskdfjahfioa";
	    		//req.getParameter("Location");
        errorMessage = "DEBUG: failure between time and parameters";
        
        try {
          errorMessage = datestart1 + "\n" + end1 + "\n" + start1;
          String array[]=datestart1.split("-");
		  String array1[]=start1.split(":");
		  errorMessage = "DEBUG: "+ array[0] + "  "+ array[1] + "  "+ array[2] + "  "+ array1[0] + "  "+ array1[1] + "  "+ array1[2];
//		  int start=(Integer.parseInt(array1[2])) + (Integer.parseInt(array1[1])*100) +(Integer.parseInt(array1[0])*10000);
		  errorMessage = "DEBUG: 1";
		  Calendar start = Calendar.getInstance();
		  errorMessage = "DEBUG: 2";
		  start.set(Integer.parseInt(array[0]), Integer.parseInt(array[1]), Integer.parseInt(array[2]), Integer.parseInt(array1[0]), Integer.parseInt(array1[1]), Integer.parseInt(array1[2]));
		  errorMessage = "DEBUG: 3";
		  errorMessage = dateEnd1 + "\n" + end1 + "\n" + start1;
          String array2[]=dateEnd1.split("-");
          errorMessage = "DEBUG: 4";
		  String array3[]=end1.split(":");
		  errorMessage = "DEBUG: 5";
		  errorMessage =  "DEBUG: "+ array2[0] + "  "+ array2[1] + "  "+ array2[2] + "  "+ array3[0] + "  "+ array3[1] + "  "+ array3[2];
//		  int end= (Integer.parseInt(array2[2])) + (Integer.parseInt(array2[1])*100) +(Integer.parseInt(array2[0])*10000);
		  Calendar end = Calendar.getInstance();
		  errorMessage = "DEBUG: 6";
		  end.set(Integer.parseInt(array2[0]), Integer.parseInt(array2[1]), Integer.parseInt(array2[2]), Integer.parseInt(array3[0]), Integer.parseInt(array3[1]), Integer.parseInt(array3[2]));
		  errorMessage = "DEBUG: 7";
          errorMessage = "DEBUG: failed at first if";
          
          

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
  		//businessName = bus_control.findBusinessByUser(username);
  		//if the user is not logged in send to login page
  		if (username == null){
  			req.getRequestDispatcher("login.jsp").forward(req, resp);
  		}
    			

          if (name == null || location == null || start == null || end == null) { // (01-01-0001) the first day.
            errorMessage = "Please fill in the event's name, start date, and end date.";
            
            //save info
            req.setAttribute("Event name", name);
            req.setAttribute("Event details", description);
            req.setAttribute("Start date", start);
            req.setAttribute("End date", end);
//            req.setAttribute("Business", businessName);		//TODO: Check all of these lines, type mismatch?
            req.setAttribute("Location", location);
            req.setAttribute("errorMessage", errorMessage);
            
            //reload
            req.getRequestDispatcher("newEvent.jsp").forward(req, resp);
          }
          
          else { //fields filled
        	  errorMessage = "failed at eventController";
            if(controller.AddEvent(name, description, start.getTimeInMillis(), end.getTimeInMillis(), businessName, location)){
            	//set new attributes to display
            	
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

