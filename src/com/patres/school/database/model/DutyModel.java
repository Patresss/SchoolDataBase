package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class DutyModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty dutyName;
	private SimpleStringProperty importance;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public DutyModel(int id, String dutyName, String importance) {
		super(id);
		this.dutyName = new SimpleStringProperty(dutyName);
		this.importance = new SimpleStringProperty(importance);
	}
	
	public DutyModel(String dutyName, String importance) {
		super();
		this.dutyName = new SimpleStringProperty(dutyName);
		this.importance = new SimpleStringProperty(importance);
	}
	
	// ================================================================================
	// To String
	// ================================================================================
	@Override
	public String toString() {
		return getDutyName();
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public String getDutyName() {
        return dutyName.get();
    }
	
    public void setDutyName(String name) {
    	dutyName.set(name);
    }
    
	public String getImportance() {
        return importance.get();
    }
	
    public void setImportance(String val) {
    	importance.set(val);
    }
	
}
