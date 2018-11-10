package ControllerTests;
import static org.junit.Assert.*;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import model.Business;
import controllers.BusinessController;
public class BusinessControllerTest {
	private Business business;
	private BusinessController con;
	@Before
	public void setUp() throws Exception {
		business=new Business();
		con = new BusinessController();
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
}
