package main;

import java.util.Date;

public class Appointment {
	
	private String id;
	private Date date;
	private String description;
	
	// constructor
	public Appointment(String id, Date date, String description) {
		
		if (id == null || id.length() > 10)
			throw new IllegalArgumentException("Invalid ID.");
		if (date == null || date.before(new Date()))
			throw new IllegalArgumentException("Invalid date");
		if (description == null || description.length() > 50)
			throw new IllegalArgumentException("Invalid description.");
		
		this.id = id;
		this.date = date;
		this.description = description;
	}

	
	// getters and setters
	// note: id is immutable and cannot be updated after instantiation
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		
		if (date == null || date.before(new Date()))
			throw new IllegalArgumentException("Invalid date");
		
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		
		if (description == null || description.length() > 50)
			throw new IllegalArgumentException("Invalid description.");
		
		this.description = description;
	}

	public String getId() {
		return id;
	}
	
	
}
