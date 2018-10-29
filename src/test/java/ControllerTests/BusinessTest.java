package ControllerTests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
//import org.junit.jupiter.api.Test;
import org.junit.Test;

import model.Business;
import controllers.BusinessController;
public class BusinessTest {
	
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

}
