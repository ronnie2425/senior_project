package controllers;
import java.sql.SQLException;

import database.DatabaseConnector;
import model.Business;

//import persist.DerbyDatabase;


public class BusinessController {
	private Business business;
	DatabaseConnector db= new DatabaseConnector();
	
	public void setBusiness(Business x){
		business = x;
	}
	
	public Business getBusiness(){
		return business;
	}
	

}
