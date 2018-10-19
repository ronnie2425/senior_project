package ControllerTests;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Event;
import controllers.EventController;
public class EventTest {
	private Event event;
	private EventController con;
	@Before
	public void setUp() throws Exception {
		event=new Event();
		con = new EventController();
	}

	@Test
	public void testSetandGet() {		
		event.setName("Event of Funness");
		con.setEvent(event);
		assertEquals("Event of Funness",con.getEvent().getName());
	}
	@Test
	public void testgetByStart() {		
		assertEquals("fake",con.findEventByStartDate(1).getBusiness());
	}
	@Test
	public void testgetByEnd() {		
		assertEquals("fake",con.findEventByEndDate(2).getBusiness());
	}
	
}
