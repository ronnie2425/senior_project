package controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Event;
import model.User;



public class EventController {
	private Event event;
	//DerbyDatabase db= new DerbyDatabase();

	public void setEvent(Event x){
		event = x;
	}
	
	public Event getEvent(){
		return event;
	}
	
	

	public Event findEventByStartDate(int date){
		//return db.findEventByStartDate(date);
		Event tmp = new Event();
		tmp.setBusiness("fake");
		tmp.setDescription("testing purposes only");
		tmp.setEndDate(2);
		tmp.setLocation("place");
		tmp.setName("something");
		tmp.setStartDate(1);
		tmp.setTime(7);
		return tmp;
	}
	
	public Event findEventByEndDate(int date){
		//return db.findEventByEndDate(date);
		Event tmp = new Event();
		tmp.setBusiness("fake");
		tmp.setDescription("testing purposes only");
		tmp.setEndDate(2);
		tmp.setLocation("place");
		tmp.setName("something");
		tmp.setStartDate(1);
		tmp.setTime(7);
		return tmp;
	}
	
	public Event findByID(int id){
		Event tmp = new Event();
		tmp.setBusiness("fake");
		tmp.setDescription("testing purposes only");
		tmp.setEndDate(2);
		tmp.setLocation("place");
		tmp.setName("something");
		tmp.setStartDate(1);
		tmp.setTime(7);
		return tmp;
	}
	public boolean editEvent(int id, String name, String description, int start_date, int end_date,int time,String business,String location){
		try{
			//TODO: update existing event with new information
			//db.editEvent("info");
		}//end try
		catch (Exception e) {
			return false;
		}//end catch
		
		return true;
		
	}
	public Boolean AddEvent(String name, String description, int start_date, int end_date,int time,String business,String location){
		try{
			//TODO: Lookup Bussiness_ID by business name string (business)
			//db.addEvent(name, description, start, end);
		}//end try
		catch (Exception e) {
			return false;
		}//end catch
		
		return true;
		
		
	}

}
