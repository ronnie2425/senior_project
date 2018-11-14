package controllers;
import static org.junit.Assert.fail;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnector;
import database.Databasequeries;
//import persist.DerbyDatabase;
import model.User;

import java.sql.SQLException;
//import model.Account;
//import persist.DerbyDatabase;

import org.apache.commons.codec.binary.*;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;



public class LoginController {
	private User login;
	DatabaseConnector db= new DatabaseConnector();
	Databasequeries info = new Databasequeries();

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
		String test = info.findAccountByName(name).get(0).getPassword();
		//String pass = hashBrowns(gimmeSalt(password));
		
		if(test.isEmpty()){
		//if(test == password){
			return false;
		}
		//System.out.println("<" + test + "> testing");
		//System.out.println("<" + test + "> testing");
			//System.out.println("<" + password + "> testing");
		if (test.equals(password)) {
			return true;
		}
		
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
	
	public String hashBrowns(String password) throws URISyntaxException {
		String salt = gimmeSalt(password);
		int iterations = 10000;
        int keyLength = 512;
        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        byte[] hashedBytes;
        String hashedString = null;
		
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" );
            PBEKeySpec spec = new PBEKeySpec( password, salt, iterations, keyLength );
            SecretKey key = skf.generateSecret( spec );
            hashedBytes = key.getEncoded( );
            hashedString = Hex.encodeHexString(hashedBytes);
        } 
        catch ( NoSuchAlgorithmException | InvalidKeySpecException e ) {
            throw new RuntimeException( e );
        }
		
		return info.hashword(password);
	}
	
	public String gimmeSalt(String password) {
		String salty = "";
		String key = "sAltYwoRdS";
		
		for(int i=0; i<password.length(); i++){
			salty += password.charAt(i) + key.charAt(i%key.length());
		}
		
		return salty;
	}
		
}//end class
