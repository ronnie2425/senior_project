package ControllerTests;
import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.User;
import controllers.LoginController;

public class LoginControllerTest {
	private User user;
	private LoginController con;
	@Before
	public void setUp() throws Exception {
		user=new User();
		con = new LoginController();
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
	
	public void testinsertRemoveAndFind() throws SQLException, URISyntaxException {
		assertTrue(con.addNewAccount("user", "tmpPass", "something", "none"));
		assertEquals("user",con.findAccountByName("user").get(0).getUsername());
		assertTrue(con.removeAccount("user"));
		assertFalse("user" == con.findAccountByName("user").get(0).getUsername());
	}
	@Test
	public void testVerify() throws SQLException, URISyntaxException {
		con.addNewAccount("user", "tmpPass", "something", "none");
		//assertTrue(con.verifyAccount("user", "tmpPass"));
		//assertFalse(con.verifyAccount("user", "falure"));
		con.removeAccount("user");
	}

}
