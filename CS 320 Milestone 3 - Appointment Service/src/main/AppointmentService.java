package main;

import java.util.ArrayList;
import java.util.Iterator;

public class AppointmentService {

	// memory for appointments
	ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	Iterator<Appointment> apptIterator;
	
	/**
	 * Adds a Appointment object to the ArrayList of Appointment objects while
	 * ensuring that the id of the new Appointment object is unique within
	 * the ArrayList. If the id is not unique, an exception is thrown.
	 * 
	 * @param appt	The Appointment object to be added.
	 */
	public void addAppointment(Appointment appt) {
		
		apptIterator = appointments.iterator();
		
		while (apptIterator.hasNext()) {
			
			if (apptIterator.next().getId().equals(appt.getId())) {
				throw new IllegalArgumentException("ID is not unique.");
			}
		}
		
		appointments.add(appt);
	}
	
	/**
	 * Removes the Appointment object that matches the param id from the ArrayList of
	 * Appointment objects. If the id is not found, an exception is thrown.
	 * 
	 * @param id	The id of the Appointment object to be removed
	 */
	public void deleteAppointment(String id) {
		
		apptIterator = appointments.iterator();
		
		while (apptIterator.hasNext()) {
			
			if (apptIterator.next().getId().equals(id)) {
				apptIterator.remove();
				return;
			}
		}
		
		throw new IllegalArgumentException("Appointment ID entered does not exist.");
	}
}