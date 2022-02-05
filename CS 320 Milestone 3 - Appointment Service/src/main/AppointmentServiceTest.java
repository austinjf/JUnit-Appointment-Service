package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	// test variables
	String id = "1234567890"; // 10 characters
	Date futureDate = new Date(System.currentTimeMillis() + 86400000); // one day in the future
	String description = "Do something important that involves 50 characters";

	@Test
	void testAddAppointment() {
		AppointmentService service = new AppointmentService();
		Appointment appt = new Appointment(id, futureDate, description);
		
		service.addAppointment(appt);
		assertTrue(service.appointments.get(0).equals(appt));
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addAppointment(appt);
		});
		
	}
	
	@Test
	void testDeleteAppointment() {
		AppointmentService service = new AppointmentService();
		Appointment appt = new Appointment(id, futureDate, description);
		Appointment anotherAppt = new Appointment("123", futureDate, description);
		service.addAppointment(appt);
		service.addAppointment(anotherAppt);
		
		service.deleteAppointment(id);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteAppointment(id);
		});
	}

}
