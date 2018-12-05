package ControllerTests;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import model.Business;
import model.User;
import controllers.BusinessController;
import controllers.LoginController;
public class BusinessControllerTest {
	private Business business;
	private BusinessController con;
	private User user;
	private LoginController lc;
	@Before
	public void setUp() throws Exception {
		business=new Business();
		con = new BusinessController();
		user=new User();
		lc=new LoginController();
	}

	@Test
	public void testSetandGetName() {		
		business.setName("test");
		con.setBusiness(business);
		assertEquals("test", con.getBusiness().getName());
	}
	@Test
	public void insertBusinessTest(){
		business.setName("test");
		business.setLocation("a place");
		con.setBusiness(business);
		assertTrue(con.insertBusiness("test", "a place"));
		assertEquals(con.findBusinessByName("test").getLocation(), business.getLocation());
		assertTrue(con.removeBusiness("test"));
	}
	@Test	
	public void testFindBusinessByOwnedUser(){
	
		
		business.setName("business");
		business.setLocation("a place");
		user.setEmail("email");
		user.setPassword("password");
		user.setUserId(3381278);
		user.setUsername("username");
		lc.addNewAccount("username", "password", "email", null);
		con.setBusiness(business);
		con.insertBusiness("business", "a place");
		con.insertOwned("username", "business");
		
		assertEquals(con.findBusinessByOwnedUser("username").get(0).getLocation(), business.getLocation());
		assertEquals(con.findBusinessByOwnedUser("username").size(),1);
		assertTrue(con.unsubscribe("username", "business"));
		assertTrue(con.removeBusiness("business"));
		assertTrue(lc.removeAccount("username"));
	
	}
	@Test
	public void testFindSubscribedBusiness(){
		business.setName("business");
		business.setLocation("a place");
		user.setEmail("email");
		user.setPassword("password");
		user.setUserId(3381278);
		user.setUsername("username");
		lc.addNewAccount("username", "password", "email", null);
		con.setBusiness(business);
		con.insertBusiness("business", "a place");
		con.insertBusiness("business2", "a place2");
		con.subscribe("username", "business");
		con.subscribe("username", "business2");
		assertEquals(con.findSubscribedBusiness("username").get(0).getName(), business.getName());
		assertEquals(con.findSubscribedBusiness("username").get(1).getName(), "business2");
		assertEquals(con.findSubscribedBusiness("username").size(),2);
		assertTrue(con.unsubscribe("username", "business"));
		assertTrue(con.unsubscribe("username", "business2"));
		assertTrue(con.removeBusiness("business"));
		assertTrue(con.removeBusiness("business2"));
		assertTrue(lc.removeAccount("username"));
	
	
	}
	public void testFindAllBusinesses(){
			
		}
	
	
}
