package controllers;
import java.sql.SQLException;

import model.Business;

//import persist.DerbyDatabase;


public class BusinessController {
	private Business business;
	//DerbyDatabase db= new DerbyDatabase();
	
	public void setBusiness(Business x){
		business = x;
	}
	
	public Business getBusiness(){
		return business;
	}
	

}
