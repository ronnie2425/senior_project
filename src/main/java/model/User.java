
package model;

public class User
{
	private String username;
	private String password;
	private String email;
	private String[] businesses;
	private static int userID;
	
	public User(String username,String password, String email, String[] businesses) {
		this.username=username;
		this.password=password;
		this.email=email;
		this.businesses=businesses;
		userID = 666;	//will have to implement changing ID later
	}
	
	public User() {
		userID = 666;	//will have to implement changing ID later
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String[] getBusinesses() {
		return businesses;
	}
	public static int getUserID() {
		return userID;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setBusinesses(String[] businesses) {
		this.businesses=businesses;
	}
	public void setUserId(int id) {
		this.userID=id;
	}

} 
