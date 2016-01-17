package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class StaffModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty degree;
	private SimpleStringProperty first;
	private SimpleStringProperty lastName;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public StaffModel(int id, String degree, String firstName, String lastName) {
		super(id);
		this.degree = new SimpleStringProperty(degree);
		this.first = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	
	public StaffModel(String degree, String firstName, String lastName) {
		super();
		this.degree = new SimpleStringProperty(degree);
		this.first = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
	}
	
	// ================================================================================
	// To String
	// ================================================================================
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getDegree());
		builder.append(" ");
		builder.append(getFirstName());
		builder.append(" " );
		builder.append(getLastName());
		
		return builder.toString();
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
        return first.get();
    }
	
    public void setLastName(String name) {
    	lastName.set(name);
    }
    
	public String getLastName() {
        return lastName.get();
    }
	
    public void setFirstName(String name) {
    	first.set(name);
    }
    
	
}
