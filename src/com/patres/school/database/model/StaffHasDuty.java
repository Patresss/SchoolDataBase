package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class StaffHasDuty extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty degree;
	private SimpleStringProperty firstName;
	private SimpleStringProperty lastName;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public StaffHasDuty(int id, String degree, String firstName, String lastName) {
		super(id);
		this.degree = new SimpleStringProperty(degree);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	
	public StaffHasDuty(String degree, String firstName, String lastName) {
		super();
		this.degree = new SimpleStringProperty(degree);
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public String getDegree() {
        return degree.get();
    }
	
    public void setDegree(String degreeName) {
    	degree.set(degreeName);
    }
    
	public String getFirstName() {
        return firstName.get();
    }
	
    public void setLastName(String name) {
    	lastName.set(name);
    }
    
	public String getLastName() {
        return lastName.get();
    }
	
    public void setFirstName(String name) {
    	firstName.set(name);
    }
    
	
}
