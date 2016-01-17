package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class SubjectModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty subjectName;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public SubjectModel(int id, String subjectName) {
		super(id);
		this.subjectName = new SimpleStringProperty(subjectName);
	}
	
	public SubjectModel(String subjectName) {
		super();
		this.subjectName = new SimpleStringProperty(subjectName);
	}
	
	// ================================================================================
	// To String
	// ================================================================================
	@Override
	public String toString() {
		return getSubjectName();
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
