package controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import persist.DerbyDatabase;
import model.User;

import java.sql.SQLException;
//import model.Account;
//import persist.DerbyDatabase;


public class LoginController {
	private User login;
	//DerbyDatabase db= new DerbyDatabase();
	
		public void setAccount(User account) {
			login=account;
		}
		
		public User getAccount() {
			return login;
		}
	
		public User findAccountByName(String name) throws SQLException{
			//return db.findAccountByUsername(name);
			User tmp = new User();;
			tmp.setPassword("tmpPass");
			tmp.setUsername("test");
			tmp.setEmail("test@insertProvier.com");
			return tmp;
		}
		
		public User getAccountbyUser(String name) throws SQLException{
			//login=db.findAccountByUsername(name);
			return login;
		}
		
		public boolean verifyAccount(String name, String password) throws SQLException{
			//return db.verifyAccountFromAccountsTableByUsernameAndPassword(name, password);
			User tmp = new User();
			tmp.setPassword("tmpPass");
			tmp.setUsername("test");
			if( tmp.getUsername() != name || tmp.getPassword() != password){
				return false;
			}
			return true;
		}
		public String[] getBusinesssFromAccount(String username){
			//TODO database call to get the businesses linked to an account
			
			return login.getBusinesses();
			
		}
		
		public boolean addNewAccount(String name, String password, String email) throws SQLException{
			return false;
			//return db.addAccountIntoAccountsTable(name, password, email);
		}
	}


	
	


