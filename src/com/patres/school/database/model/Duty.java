package com.patres.school.database.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Duty extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty dutyName;
	private SimpleIntegerProperty importance;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public Duty(int id, String dutyName, int importance) {
		super(id);
		this.dutyName = new SimpleStringProperty(dutyName);
		this.importance = new SimpleIntegerProperty(importance);
	}
	
	public Duty(String dutyName, int importance) {
		super();
		this.dutyName = new SimpleStringProperty(dutyName);
		this.importance = new SimpleIntegerProperty(importance);
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
    
	public Integer getImportance() {
        return importance.get();
    }
	
    public void setImportance(Integer val) {
    	importance.set(val);
    }
	
}
