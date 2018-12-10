package controllers;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnector;
import model.Event;
import model.User;
import database.Databasequeries;


public class EventController {
	private Event event;
	DatabaseConnector db= new DatabaseConnector();
	Databasequeries queries = new Databasequeries();
	public void setEvent(Event x){
		event = x;
	}
	
	public Event getEvent(){
		return event;
	}
	public List<Event> findEventByBusiness(String business){
		try{
			return queries.findEventByBusiness(business);
		}
		catch (Exception e) {
			return null;
		}

	}
	public Event findByID(int id){
		try{
			return queries.findEventByID(id).get(0);
		}
		catch (Exception e) {
			return null;
		
	}
	}
	public boolean editEvent(String name, String description, long start_date, long end_date, String business, String location){
		try{
			int id=queries.findEventByName(name).get(0).getId();
			queries.removeEvent(name,business);
			queries.insertEvent(name, description, start_date, end_date, business, location, id);
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
		
	}
	public boolean AddEvent(String name, String description, long start_date, long end_date, String business, String location) {
			int id =(int) (Math.random()*10000);
			List<Event> events;
			try {
				events = queries.findEventByName(name);
				if (events.isEmpty()) {
				
					queries.insertEvent(name, description, start_date, end_date, business, location,id);
					return true;
				}
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			
			return false;
	}	
	
	
	public boolean removeEvent(String name, String description, long start_date, long end_date,String business,String location){
		try{
			queries.removeEvent(name, business);
		}
		
		catch (Exception e) {
			return false;
		}
		
		return true;
		
		
	}
	public List<Event> findByName(String name){
		try{
			return queries.findEventByName(name);
		}
		catch (Exception e) {
			return null;
		
	}
}
}
