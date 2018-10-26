package controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnector;
//import persist.DerbyDatabase;
import model.User;

import java.sql.SQLException;
//import model.Account;
//import persist.DerbyDatabase;


public class LoginController {
	private User login;
	DatabaseConnector db= new DatabaseConnector();
	
		public void setAccount(User account) {
			login=account;
		}
		
		public User getAccount() {
			return login;
		}
	
		public User findAccountByName(String name) throws SQLException{
			try{
				//TODO make this
				return null;//db.findAccountByUsername(name);
			}
			catch (Exception e) {
				User tmp = new User();;
				tmp.setPassword("tmpPass");
				tmp.setUsername("test");
				tmp.setEmail("test@insertProvier.com");
				return tmp;
			}
			
		}
		
		public User getAccountbyUser(String name) throws SQLException{
			try{
				//TODO make this
				login=null;//db.findAccountByUsername(name);
				return login;
			}
			catch (Exception e) {
				return login;
			}
			
		}
		
		public boolean verifyAccount(String name, String password) throws SQLException{
			try{
				//TODO make this
				return false;//db.verifyAccountFromAccountsTableByUsernameAndPassword(name, password);
			}
			catch (Exception e) {
				User tmp = new User();
				tmp.setPassword("tmpPass");
				tmp.setUsername("test");
				if( tmp.getUsername() != name || tmp.getPassword() != password){
					return false;
				}
				return true;
			}
			
		}
		
		//TODO wtf is this supposed to do?
		public String[] getBusinesssFromAccount(String username){
			//TODO database call to get the businesses linked to an account
			
			return login.getBusinesses();
			
		}
		
		public boolean addNewAccount(String name, String password, String email) throws SQLException{
			try{
				//TODO make this
				return true;//db.addAccountIntoAccountsTable(name, password, email);
			}
			catch (Exception e) {
				return false;
			}
		}
		
}//end class


	
	


