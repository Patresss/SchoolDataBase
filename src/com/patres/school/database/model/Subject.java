package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class Subject extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty subjectName;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public Subject(int id, String subjectName) {
		super(id);
		this.subjectName = new SimpleStringProperty(subjectName);
	}
	
	public Subject(String subjectName) {
		super();
		this.subjectName = new SimpleStringProperty(subjectName);
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public String getSubjectName() {
        return subjectName.get();
    }
	
    public void setSubjectName(String name) {
    	subjectName.set(name);
    }
    
}
