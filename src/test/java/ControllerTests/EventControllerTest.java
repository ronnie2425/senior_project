package ControllerTests;
import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import model.Event;
import controllers.EventController;
public class EventControllerTest {
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
	public void testInsert() {
		assertTrue(con.AddEvent("test2526", "fun stuff", 1, 2, "fake", "a place"));
		assertEquals(con.findByName("test2526").get(0).getLocation(),"a place" );
	}
	@Test
	public void testgetByStart() {		
		assertEquals("fake",con.findEventByStartDate(1).get(0).getBusiness());
	}
	@Test
	public void testgetByEnd() {		
		assertEquals("fake",con.findEventByEndDate(2).get(0).getBusiness());
	}
	public void testFindByBusiness(){
		assertEquals("test", con.findEventByBusiness("fake").get(0).getName());
	}
	@Test
	public void testRemove(){
		assertTrue(con.removeEvent("test", "fun stuff", 1, 2, "fake", "a place"));
	}
}
