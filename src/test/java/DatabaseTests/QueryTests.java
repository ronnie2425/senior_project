//package DatabaseTests;
//
//
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import database.*;
//import database.Databasequeries.Transaction;
//
//import java.net.URISyntaxException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import static org.junit.Assert.*;
//import java.util.List;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import database.*;
//import model.*;
//
//
//public class QueryTests {
//
//	private Databasequeries db = null;
//	
//	
//	
//	
//	List<User> users = null;
//	List<Event> events = null;
//	List<Business> businesses = null;
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception
//	{
//		
//	}
//	
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception
//	{
//		
//	}
//	
//	@Before
//	public void setUp() throws Exception
//	{
//		db = new Databasequeries();
//	}
//	
//	@After
//	public void tearDown() throws Exception
//	{
//		
//	}
//	
//	@Test
//	public void TestinsertUser() throws URISyntaxException{
//		System.out.println("\n*** Testing InsertUser ***");
//		
//		String user = "ricardon";
//		String pass = "kelly";
//		String email = "iam@tired.rn";
//		int id=5;
//		
//		users = db.findAccountByName(user);
//		if (!users.isEmpty())
//		{
//			System.out.println("Failed to insert User");
//			fail("User already exists");
//		}
//		else
//		{
//			db.insertUser(user, pass, email,id);
//			System.out.println("User successfully inserted");
//		}
//		
//	}
//
//	
//	@Test
//	public void TestinsertBusiness() throws URISyntaxException{
//		System.out.println("\n*** Testing InsertBusiness ***");
//		
//		String business = "Shortbus Inc";
//		String location = "Back of the shortbus";
//		int id=5;
//		
//		businesses = db.findBusinessByName(business);
//		if (!users.isEmpty())
//		{
//			System.out.println("Failed to insert Business");
//			fail("Business already exists");
//		}
//		else
//		{
//			db.insertBusiness(business,location,id);
//			System.out.println("Business successfully inserted");
//		}
//		
//	}
//	
//	
//	@Test
//	public void TestinsertEvent() throws URISyntaxException{
//		System.out.println("\n*** Testing InsertEvent ***");
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
//			db.insertEvent(name,description,start,end,time,business,location,id);
//			System.out.println("Event successfully inserted");
//		}
//	}
//
//	@Test
//	public void TestfindEventByStartDate() throws URISyntaxException{
//		
//	}
//
//	@Test
//	public void TestfindEventByendDate() throws URISyntaxException{
//		
//	}
//
//	@Test
//	public void TestfindEventByID() throws URISyntaxException{
//		
//	}
//
//	@Test
//	public void TesteditEvent() throws URISyntaxException{
//		
//	}
//
//	@Test
//	public void TestfindAccountByName() throws URISyntaxException{
//		System.out.println("\n*** Testing FindUser ***");
//		
//		String username = "ricardon";
//		users = db.findAccountByName(username);
//		if (users.isEmpty())
//		{
//			System.out.println("Ah fuck, you goofed");
//			fail("No user found with username <" + username + ">");
//		}
//		else
//		{
//			System.out.println("User <" + username + "> found!");
//		}
//		
//	}
//
//	@Test
//	public void TestgetBusinesssFromAccount() throws URISyntaxException{
//		
//	}
//	
//
//
//
//
//
//	
//	
//
//	
//	@Test
//	public void TestFindPosts()
//	{
//		System.out.println("\n*** Testing FindPosts ***");
//		
//		String pf = "platform1";
//		String game = "game1";
//		String trade = "trade";
//		posts = db.findPosts(pf, game, trade);
//		if (posts.isEmpty())
//		{
//			System.out.println("Ah fuck, you goofed");
//			fail("No post found with specified information");
//		}
//		else
//		{
//			System.out.println("Posts found!");
//		}
//	}
//	
//	@Test
//	public void TestFindNot()
//	{
//		System.out.println("\n*** Testing FindNotification ***");
//		
//		int postId = 1;
//		
//		notifications = db.findNot(postId);
//		if (notifications.isEmpty())
//		{
//			System.out.println("Ah fuck, you goofed");
//			fail("No notification found with specified information");
//		}
//		else
//		{
//			System.out.println("Notification found: " + notifications.get(0).getNotification());
//		}
//	}
//	
//	@Test
//	public void TestInsertPost()
//	{
//		System.out.println("\n*** Testing InsertPost ***");
//		
//		int userid = 2;
//		String pf = "xbox365";
//		String game = "Warframe";
//		String trade = "buy";
//		int time = 0;
//		String msg = "pls work";
//		
//		posts = db.findPosts(pf, game, trade);
//		if (!posts.isEmpty())
//		{
//			System.out.println("Failed to insert Post");
//			fail("Post already exists");
//		}
//		else
//		{
//			db.insertPost(userid, pf, game, trade, time, msg);
//			System.out.println("Post successfully inserted");
//		}
//	}
//	
//	@Test
//	public void TestInsertUser()
//	{
//		System.out.println("\n*** Testing InsertUser ***");
//		
//		String user = "ricardon";
//		String pass = "kelly";
//		String email = "iam@tired.rn";
//		
//		users = db.findUser(user);
//		if (!users.isEmpty())
//		{
//			System.out.println("Failed to insert User");
//			fail("User already exists");
//		}
//		else
//		{
//			db.insertUser(user, pass, email);
//			System.out.println("User successfully inserted");
//		}
//	}
//	
//
//	@Test
//	public void TestInsertNotification()
//	{
//		System.out.println("\n*** Testing InsertNotification ***");
//		
//		int userid = 2;
//		String msg = "work!!";
//		
//		notifications = db.findNot(20);
//		if (!notifications.isEmpty())
//		{
//			System.out.println("Failed to insert Notification");
//			fail("Notification already exists");
//		}
//		else
//		{
//			db.insertNotification(userid, msg);
//			System.out.println("Notification successfully inserted");
//		}
//	}
//	@Test
//	public void TestInsertChat()
//	{
//		System.out.println("\n*** Testing Insertchat ***");
//		
//		int userid = 2;
//		int postid = 2;
//		String msg = "work!!";
//		
//		db.insertChat(msg, userid, postid);
//		chat = db.findChatbyPost(postid);
//		if (chat.isEmpty())
//		{
//			System.out.println("Failed to insert chat");
//			fail("chat messed up");
//		}
//		else
//		{
//			//db.insertNotification(userid, msg);
//			//System.out.println("Notification successfully inserted");
//		}
//	}
//
//}
//
//
//public class QueryTests {
//
//	private Databasequeries db = new Databasequeries();
//	
//	
//	
//	
//	
//	
//
//List<User> users = null;
////	@Test
////	public void TestFindUser() throws URISyntaxException
////	{
////		System.out.println("\n*** Testing FindUser ***");
////		
////		String username = "username";
////		
////		users = db.findUser(username);
////		if (users.isEmpty())
////		{
////			System.out.println("Ah fuck, you goofed");
////			fail("No user found with username <" + username + ">");
////		}
////		else
////		{
////			System.out.println("User <" + username + "> found!");
////		}
////	}
//	
//	@Test
//	public void TestInsertUser() throws URISyntaxException
//	{
//		System.out.println("\n*** Testing InsertUser ***");
//		
//		String user = "ricardon123";
//		String pass = "kelly";
//		String email = "iam@tired.rn";
//		
//		users = db.insertUser(user,pass,email,8);
//		if (!users.isEmpty())
//		{
//			System.out.println("Failed to insert User");
//			fail("User already exists");
//		}
//		else
//		{
//			db.insertUser(user, pass, email,8);
//			System.out.println("User successfully inserted");
//		}
//	}
//}
