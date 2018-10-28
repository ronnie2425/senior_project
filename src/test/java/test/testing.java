package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;





import org.junit.Test;

import model.Business;
import model.User;
import database.test1;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


public class testing {

	private test1 db = null;

List<User> users = null;
	@Test
	public void TestFindUser() throws URISyntaxException
	{
		System.out.println("\n*** Testing FindUser ***");
		
		String username = "username";
		
		users = db.findUser(username);
		if (users.isEmpty())
		{
			System.out.println("Ah fuck, you goofed");
			fail("No user found with username <" + username + ">");
		}
		else
		{
			System.out.println("User <" + username + "> found!");
		}
	}
	
	@Test
	public void TestInsertUser() throws URISyntaxException
	{
		System.out.println("\n*** Testing InsertUser ***");
		
		String user = "ricardon";
		String pass = "kelly";
		String email = "iam@tired.rn";
		
		users = db.findUser(user);
		if (!users.isEmpty())
		{
			System.out.println("Failed to insert User");
			fail("User already exists");
		}
		else
		{
			db.insertUser(user, pass, email);
			System.out.println("User successfully inserted");
		}
	}
}
