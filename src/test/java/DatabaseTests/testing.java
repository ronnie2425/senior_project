package DatabaseTests;



import static org.junit.Assert.*;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.User;
import database.*;


import java.net.URISyntaxException;



public class testing {

	private Databasequeries db = new Databasequeries();
	
	
	
	
	
	

List<User> users = null;
//	@Test
//	public void TestFindUser() throws URISyntaxException
//	{
//		System.out.println("\n*** Testing FindUser ***");
//		
//		String username = "username";
//		
//		users = db.findUser(username);
//		if (users.isEmpty())
//		{
//			System.out.println("Ah fuck, you goofed");
//			fail("No user found with username <" + username + ">");
//		}
//		else
//		{
//			System.out.println("User <" + username + "> found!");
//		}
//	}
	
	@Test
	public void TestInsertUser() throws URISyntaxException
	{
		System.out.println("\n*** Testing InsertUser ***");
		
		String user = "ricardon123";
		String pass = "kelly";
		String email = "iam@tired.rn";
		
		users = db.insertUser(user,pass,email,8);
		if (!users.isEmpty())
		{
			System.out.println("Failed to insert User");
			fail("User already exists");
		}
		else
		{
			db.insertUser(user, pass, email,8);
			System.out.println("User successfully inserted");
		}
	}
}
