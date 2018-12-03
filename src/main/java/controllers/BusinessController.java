package controllers;
import java.sql.SQLException;
import java.util.List;

import database.DatabaseConnector;
import model.Business;
import model.Event;
import database.Databasequeries;


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
	
	public List<Business> findBusinessByOwnedUser(String name){
		try{
			return queries.findOwnedBusinesssFromAccount(name);
		}
		catch (Exception e){
			return null;
		}
	
	}
	
	public List<Business> findSubscribedBusiness(String name){
		try{
			return queries.findBusinesssFromAccount(name);
		}
		catch (Exception e){
			return null;
		}
	
	}
	public void unsubscribe(String u_id,String b_id){
		try{
			queries.removeRelation(u_id, b_id);
		}
		catch (Exception e){

		}
	
	}
	public void subscribe(String u_id,String b_id){
		try{
			queries.insertRelation(u_id, b_id);
		}
		catch (Exception e){

		}
	
	}
	public void insertOwned(String u_id,String b_id){
		try{
			queries.insertOwn(u_id, b_id);
		}
		catch (Exception e){

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
	public List<Business> findAllBusinesses(){
		try{
			return queries.findAllBusinesses();
		}
		catch (Exception e){
			return null;
		}
	
	}

}

