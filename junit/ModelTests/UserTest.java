package ModelTests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.User;

public class UserTest {
	private User user;
	private String[] businesses;
	@Before
	public void setUp() throws Exception {
		businesses= new String[]{"business 1", "these", "are","tests", "octopus"};
		user=new User();
	}

	@Test
	public void testSetandGetUsername() {		
		user.setUsername("Richard Kellington");
		assertEquals("Richard Kellington",user.getUsername());
	}
	@Test
	public void testSetandGetPassword() {
		user.setPassword("secret");
		assertEquals("secret",user.getPassword());
	}
	@Test
	public void testSetandGetEmail() {
		user.setEmail("Outofjokes@tired.late");
		assertEquals("Outofjokes@tired.late",user.getEmail());
	}
	@Test
	public void testSetandGetBusinesses() {
		user.setBusinesses(businesses);
		assertEquals(businesses[0],user.getBusinesses()[0]);
		assertEquals(businesses[1],user.getBusinesses()[1]);
		assertEquals(businesses[2],user.getBusinesses()[2]);
		assertEquals(businesses[3],user.getBusinesses()[3]);
		assertEquals(businesses[4],user.getBusinesses()[4]);
	}

}
