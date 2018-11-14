package controllers;
import java.sql.SQLException;
import java.util.List;

import database.DatabaseConnector;
import model.Business;
import model.Event;
import database.Databasequeries;
//import persist.DerbyDatabase;


public class BusinessController {
	private Business business;
	DatabaseConnector db= new DatabaseConnector();
	Databasequeries queries = new Databasequeries();
	public void setBusiness(Business x){
		business = x;
	}
	
	public Business getBusiness(){
		return business;
	}
	public boolean insertBusiness(String name,String location){
		try{
			int id =(int) (Math.random()*10000);
			boolean exist=true;
			List<Business> events = null;
			int count=1;
			
			while(exist=true) {
				events = queries.findBusinessById(id);
				if (!events.isEmpty())
				{
					break;
				
				}
				else {
					id=((id^count)%10000);
					count++;
				}
			}
			queries.insertBusiness(name, location, id);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	public Business findBusinessByName(String name){
		try{
			return queries.findBusinessByName(name).get(0);		}
		catch (Exception e){
			return null;
		}
		
	} 
	
	public String findBusinessByUser(String name){
		try{
			return queries.findRelationsByUser(name);
		}
		catch (Exception e){
			return null;
		}
		
	}
	
	public boolean removeBusiness(String name){
		try{
			queries.removeBusiness(name);
		}
		catch (Exception e){
			return false;
		}
		return true;
	}
	

}

