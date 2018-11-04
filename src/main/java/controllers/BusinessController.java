package controllers;
import java.sql.SQLException;

import database.DatabaseConnector;
import model.Business;
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
	public boolean insertBusiness(String name,String location,int id){
		try{
			queries.insertBusiness(name, location, id);
		}
		catch (Exception e){
			return false;
		}
		return true;
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
