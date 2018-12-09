package ControllerTests;
import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.User;
import controllers.LoginController;
import controllers.SecurityController;

public class LoginControllerTest {
	private User user;
	private LoginController con;
	private SecurityController sec;
	
	@Before
	public void setUp() throws Exception {
		user=new User();
		con = new LoginController();
		sec = new SecurityController(11);
		User user = new User();;
		user.setPassword("tmpPass");
		user.setUsername("test");
		user.setEmail("test@insertProvier.com");
	}

	@Test
	public void testSetandGetUser() {	
		con.setAccount(user);
		assertEquals(user ,con.getAccount());
	}
	
	@Test
	public void testinsertRemoveAndFind() {
		assertTrue(con.addNewAccount("user", "tmpPass", "something", "none"));
		assertEquals("user",con.findAccountByName("user").get(0).getUsername());
		assertTrue(con.removeAccount("user"));
		assertTrue(con.findAccountByName("user").isEmpty());
	}

	
	@Test
	public void testVerifyExtensive()  {
		String temp = sec.applyHash("password");
		System.out.println(temp);
		String temp2 = con.hashBrowns("password");
		System.out.println(temp2);
		
		if(temp.equals(temp2)){
			System.out.println("They match!");
			if(sec.verifyHash("password", temp2)){
				System.out.println("Verified!");
				
				System.out.println("Insert: " + con.addNewAccount("user", "tmpPass", "something", "none"));
	
				con.removeAccount("user");
			}
			else{
				System.out.println("Verification failed. Check param types?");
			}
			
		}
		else{
			System.out.println("They don't match. Check middleman method?");
		}
		
		
		
	}

}
