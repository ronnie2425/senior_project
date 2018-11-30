package DatabaseTests;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controllers.LoginController;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.*;
import database.*;


public class QueryTests {

	private Databasequeries db = null;
	
	
	List<User> users = null;
	List<Event> events = null;
	List<Business> businesses = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		
	}
	
	@Before
	public void setUp() throws Exception
	{
		db = new Databasequeries();
	}
	
	@After
	public void tearDown() throws Exception
	{
		
	}
	
	@Test
	public void TestinsertUser() throws URISyntaxException{
		System.out.println("\n*** Testing InsertUser ***");
		
		String user = "ricardon";
		String pass = "kelly";
		String email = "iam@tired.rn";
		int id=5;
	
		users = db.findAccountByName(user);
		if (!users.isEmpty())
		{
			System.out.println("Failed to insert User");
			fail("User already exists");
		}
		else
		{
			db.insertUser(user, pass, email,id);
			System.out.println("User successfully inserted");
			db.removeUser(user);
		
		}
		
	}

	
	@Test
	public void TestinsertBusiness() throws URISyntaxException{
		System.out.println("\n*** Testing InsertBusiness ***");
		
		String business = "Shortbus Inc";
		String location = "Back of the shortbus";
		int id=5;
		
		businesses = db.findBusinessByName(business);
		if (!businesses.isEmpty())
		{
			System.out.println("Failed to insert Business");
			fail("Business already exists");
		}
		else
		{
			db.insertBusiness(business,location,id);
			System.out.println("Business successfully inserted");
			db.removeBusiness(business);
	}
		
	}
	
	
	@Test
	public void TestinsertEvent() throws URISyntaxException{
		System.out.println("\n*** Testing InsertEvent ***");
		
		String name="Event of Fun";
		String description="You WILL enjoy the event";
		int start=12418;
		int end=12518;
		int time=1800;
		String business="Shortbus Inc";
		String location="Nowhere";
		int id=5;

		events = db.findEventByName(name);
		if (!events.isEmpty())
		{
			System.out.println("Failed to insert Event");
			fail("Event already exists");
		}
		else
		{
			db.insertEvent(name,description,start,end,time,business,location,id);
			System.out.println("Event successfully inserted");
			db.removeEvent(name,business);
		}
	}

	@Test
	public void TestfindEventByStartDate() throws URISyntaxException{
		System.out.println("\n*** Testing findEventByStartDate ***");
		String name="Event of Fun";
		String description="You WILL enjoy the event";
		int start=12418;
		int end=12518;
		int time=1800;
		String business="Shortbus Inc";
		String location="Nowhere";
		int id=5;
		db.insertEvent(name,description,start,end,time,business,location,id);
		
		events = db.findEventByStartDate(12418);
		db.removeEvent(name,business);
		if (events.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No event found with date <" + start + ">");
		}
		else
		{
			System.out.println("Event with start date <" + start + "> found!");
		}
		
		
	}
	
//
	@Test
	public void TestfindEventByEndDate() throws URISyntaxException{
		System.out.println("\n*** Testing findEventByEndDate ***");
		
		String name="Event of Fun";
		String description="You WILL enjoy the event";
		int start=12418;
		int end=12518;
		int time=1800;
		String business="Shortbus Inc";
		String location="Nowhere";
		int id=5;
		db.insertEvent(name,description,start,end,time,business,location,id);
		
		int date = 12518;
		events = db.findEventByEndDate(12518);
		db.removeEvent(name,business);
		if (events.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No event found with date <" + date + ">");
		}
		else
		{
			System.out.println("Event with end date <" + date + "> found!");
		}
	}
//
	@Test
	public void TestfindEventByID() throws URISyntaxException{
		System.out.println("\n*** Testing findEventById ***");
		String name="Event of Fun";
		String description="You WILL enjoy the event";
		int start=12418;
		int end=12518;
		int time=1800;
		String business="Shortbus Inc";
		String location="Nowhere";
		int id=5;
	
		db.insertEvent(name,description,start,end,time,business,location,id);
		
		events = db.findEventByID(5);
		db.removeEvent(name,business);
		
		if (events.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No event found with date <" + id + ">");
		}
		else
		{
			System.out.println("Event with id <" + id + "> found!");
		}
	}

//	@Test
//	public void TesteditEvent() throws URISyntaxException{
//		System.out.println("\n*** Testing EditEvent ***");
//		
//		String name="Event of Fun";
//		String description="You WILL enjoy the event";
//		int start=12418;
//		int end=12518;
//		int time=1800;
//		int business=5;
//		String location="Nowhere";
//		int id=5;
//		
//		events = db.findEventByName(name);
//		if (!events.isEmpty())
//		{
//			System.out.println("Failed to insert Event");
//			fail("Event already exists");
//		}
//		else
//		{
//			db.editEvent(name,description,start,end,time,business,location,id);
//			System.out.println("Event successfully edited");
//		}
//	}
//
//
	@Test
	public void TestgetBusinesssFromAccount() throws URISyntaxException{
		System.out.println("\n*** Testing FindBusinesssFromAccount ***");
		String user = "ricardon";
		String pass = "kelly";
		String email = "iam@tired.rn";
		int u_id=5;
		db.removeUser(user);
		db.insertUser(user, pass, email,u_id);
		
		String business = "Shortbus Inc";
		String location = "Back of the shortbus";
		int b_id=5;
		db.removeBusiness(business);
		db.insertBusiness(business,location,b_id);
		
		db.insertRelation(user,business);
		
		
	
		businesses = db.findBusinesssFromAccount(user);
		db.removeBusiness(business);
		db.removeUser(user);
		db.removeRelation(user,business);
		
		if (businesses.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No business found with user <" + user + ">");
		}
		else
		{
			System.out.println("Business <" + business + "> found!");
		}
		
	}
	@Test
	public void Testhash() throws URISyntaxException{
	String test=db.hashword("password");
	System.out.println(test);
	
	
	}
	@Test
	public void Test() throws URISyntaxException{
		String pass;
		 LoginController controller = new LoginController();
		 
		pass = controller.gimmeSalt("PASSWORD");
        pass = controller.hashBrowns(pass);
		db.insertUser("TESTER", pass, "EMAIL",666);
		
		db.insertBusiness("Test1","Somewhere",7);
		db.insertBusiness("Test2","Somewhere",8);
		db.insertBusiness("Test3","Somewhere",9);
		
		db.insertEvent("t1","This is a testert",102019,122519,120000,"Test1","Somewhere",1231);
		db.insertEvent("t2","This is a testert",102119,122519,120000,"Test1","Somewhere",674754);
		db.insertEvent("t3","This is a testert",112219,122519,120000,"Test2","Somewhere",241254);
		db.insertEvent("t4","This is a testert",112319,122519,120000,"Test2","Somewhere",5432);
		db.insertEvent("t5","This is a testert",122419,122519,120000,"Test3","Somewhere",12);
		db.insertEvent("t6","This is a testert",122519,122519,120000,"Test3","Somewhere",1241);
		
		db.insertRelation("Test1", "TESTER");
		db.insertRelation("Test3", "TESTER" );
		db.insertRelation("Test2","TESTER");
	}
}

