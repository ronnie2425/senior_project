
package model;

public class Business implements Comparable<Business>{
	private String name;
	private int id;
	private String location;
	
	public Business() {
		
	}
	
	public Business(String name, int id, String location) {
		this.name=name;
		this.id=id;
		this.location=location;
	}
	
	public Business(String name) {
		this.name=name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setID(int id) {
		this.id=id;
	}
	public void setLocation(String location) {
		this.location=location;
	}
	
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
	public String getLocation() {
		return location;
	}
	public int compareTo(Business e) {
		return  this.name.compareTo(e.getName());
	}
} 
