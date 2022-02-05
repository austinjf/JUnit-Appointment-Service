package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	// test variables
	String id = "1234567890"; // 10 characters
	Date futureDate = new Date(System.currentTimeMillis() + 86400000); // one day in the future
	String description = "Do something important that involves 50 characters";
	
	@Test
	void testApptClass() {
		Appointment appt = new Appointment(id, futureDate, description);
		
		assertTrue(appt.getId().equals(id));
		assertTrue(appt.getDate().equals(futureDate)); // object comparison
		assertTrue(appt.getDescription().equals(description));
	}
	
	@Test
	void testApptClassIdException() {
		String tooLongId = "12345678909"; // 11 characters
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appt = new Appointment(tooLongId, futureDate, description);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appt = new Appointment(null, futureDate, description);
		});
		
	}
	
	@Test
	void testApptClassDateException() {
		Date pastDate = new Date(System.currentTimeMillis() - 86400000); // Date object with current time
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment pastAppt = new Appointment(id, pastDate, description);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment nullAppt = new Appointment(id, null, description);
		});
	}
	
	@Test
	void testApptClassDescriptionException() {
		// 51 characters
		String tooLongDescription = "Do something that is not as important as before now";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appt = new Appointment(id, futureDate, tooLongDescription);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Appointment appt = new Appointment(id, futureDate, null);
		});
	}
	
	@Test
	void testApptDateSetter() {
		Date pastDate = new Date(System.currentTimeMillis() - 86400000); // Date object with current time
		Date newFutureDate = new Date(System.currentTimeMillis() + (86400000 * 2));
		Appointment appt = new Appointment(id, futureDate, description);
		
		appt.setDate(newFutureDate);
		assertTrue(appt.getDate().equals(newFutureDate));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.setDate(pastDate);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.setDate(null);
		});
	}
	
	@Test
	void testApptDescriptionSetter() {
		// 51 characters
		String newDescription = "Something else I need to do";
		String tooLongDescription = "Do something that is not as important as before now";
		Appointment appt = new Appointment(id, futureDate, description);
		
		appt.setDescription(newDescription);
		assertTrue(appt.getDescription().equals(newDescription));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.setDescription(tooLongDescription);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			appt.setDescription(null);
		});
		
	}

}
