package ModelTests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import model.Business;

public class BusinessTest {
	private Business business;
	@Before
	public void setUp() throws Exception {
		business=new Business();
	}

	@Test
	public void testSetandGetName() {		
		business.setName("Richard Kellington");
		assertEquals("Richard Kellington",business.getName());
	}
	@Test
	public void testSetandGetPassword() {
		business.setID(5);
		assertEquals(5,business.getID());
	}
	@Test
	public void testSetandGetEmail() {
		business.setLocation("Location");
		assertEquals("Location",business.getLocation());
	}
	

}
