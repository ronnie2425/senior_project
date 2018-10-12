package ControllerTests;
import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import model.User;
import controllers.LoginController;

public class LoginTest {
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
	public void testgetAccountByUsername() throws SQLException {
		assertEquals("tmpPass",con.getAccountbyUser("test").getPassword());
	}
	@Test
	public void testVerify() throws SQLException {
		assertTrue(con.verifyAccount("test", "tmpPass"));
	}

}
