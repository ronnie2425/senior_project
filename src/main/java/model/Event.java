
package model;

public class Event
{
	private String name;
	private String description;
	private int start_date;
	private int end_date;
	private int time;
	private String business;
	private String location;
	private int id;
	
	public Event(String name, String description, int start_date,
			int end_date,int time,String business,String location,int id) {
		
		this.name=name;
		this.description=description;
		this.start_date=start_date;
		this.end_date=end_date;
		this.time=time;
		this.business=business;
		this.location=location;
		this.id=id;
	
	}
	
	public Event() {
		
	}
	public void setName(String name){
		this.name=name;
	}
	public void setDescription(String desc){
		this.description=desc;
	}
	public void setStartDate(int start_date){
		this.start_date=start_date;
	}
	public void setEndDate(int end_date){
		this.end_date=end_date;
	}
	public void setTime(int time){
		this.time=time;
	}
	public void setBusiness(String bus){
		this.business=bus;
	}
	public void setLocation(String loc){
		this.location=loc;
	}
	public void setId(int id){
		this.id=id;
	}
	
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	public int getStartDate(){
		return start_date;
	}
	public int getEndDate(){
		return end_date;
	}
	public int getTime(){
		return time;
	}
	public String getBusiness(){
		return business;
	}
	public String getLocation(){
		return location;
	}
	public int getId(){
		return id;
	}
	
	
} 
