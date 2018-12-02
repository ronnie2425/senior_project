package controllers;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import database.DatabaseConnector;
import database.Databasequeries;
import model.User;



public class LoginController {
	private User login;
	DatabaseConnector db= new DatabaseConnector();
	Databasequeries info = new Databasequeries();
	private static final SecurityController hacker = new SecurityController(11);


	public void setAccount(User account) {
		login=account;
	}
	
	public User getAccount() {
		return login;
	}

	public List<User> findAccountByName(String name) throws SQLException{
		try{
			//TODO make this
			return info.findAccountByName(name);
		}
		catch (Exception e) {
			return null;
		}
		
	}
	
	public boolean verifyAccount(String name, String password) throws SQLException, URISyntaxException{
		if(!info.findAccountByName(name).isEmpty()){//shell isEmpty check, empty list may store a value in string?
			String test = info.findAccountByName(name).get(0).getPassword();
			//String pass = hashBrowns(gimmeSalt(password));		//REDUNDANT, remove from final project
			
			if(test.isEmpty() || test.equals("")){
			//if(test == password){
				return false;
			}
			//System.out.println("<" + test + "> testing");
			//System.out.println("<" + test + "> testing");
				//System.out.println("<" + password + "> testing");
	//		Function<String, Boolean> update = new Function<String, Boolean>() {
	//			public Boolean apply(String hash) { String[] mutableHash = {""};
	//			mutableHash[0] = hash; return true; }
	//		};
			if (hacker.verifyHash(password, test)) {
				return true;
			}
		}//end if has results
		
		return false;
	}
	
	
	public boolean addNewAccount(String name, String password, String email, String business) throws SQLException, URISyntaxException{			
		int id =(int) (Math.random()*10000);
		boolean exist=true;
		List<User> users = null;
		int count=1;
/*				
		while(exist==true) {
			users = info.findAccountById(id);
			if (!users.isEmpty())
			{
				exist=false;
				break;
			
			}
			else {
				id=((id^count)%10000);
				count++;
			}
		}
*/
		//password =  hashBrowns(gimmeSalt(password));		//REDUNDANT, remove from final project
		users = info.findAccountByName(name);
		if (!users.isEmpty()){
			return false;
		}
		info.insertUser(name, password, email, id);

		return true;
	
		
	}
	public boolean removeAccount(String name){
		try{
			info.removeUser(name);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	

	public static boolean verifyAndUpdateHash(String password, String hash, Function<String, Boolean> updateFunc) {
	    return hacker.verifyAndUpdateHash(password, hash, updateFunc);
	}//basically unused, possible future upgrade
	
	public String hashBrowns(String password) throws URISyntaxException {
		return hacker.fuckYou(password);
	}
	
	
	/**
	 * Adds salt to a String.
	 * The encryption algorithm adds its own salt to the passwords automatically.
	 * This method IS NOT the security, but it was a proof of concept that now serves to add a little extra salt and length to the password before encryption.
	 * @see SecurityController
	 * @param password The user-entered password.
	 * @return The salted password (String).
	 */
	public String gimmeSalt(String password) {
		String salty = "";
		String key = "sAltYwoRdS";
		
		for(int i=0; i<password.length(); i++){
			salty += password.charAt(i) + key.charAt(i%key.length());
		}//end salting loop
		
		return salty;
	}//end gimmeSalt
		
}//end class
