
package model;

public class Event implements Comparable<Event>
{
	private String name;
	private String description;
	private Long start_date;
	private Long end_date;
	private String business;
	private String location;
	private int id;
	
	public Event(String name, String description, Long start_date,
			Long end_date,String business,String location,int id) {
		
		this.name=name;
		this.description=description;
		this.start_date=start_date;
		this.end_date=end_date;
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
	public void setStartDate(long start_date){
		this.start_date=start_date;
	}
	public void setEndDate(long end_date){
		this.end_date=end_date;
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
	public Long getStart(){
		return start_date;
	}
	public Long getEndDate(){
		return end_date;
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
	//@Override
	public int compareTo(Event e) {
		return  (Math.toIntExact(start_date) - Math.toIntExact(e.getStart()));
	}
	
	
} 
