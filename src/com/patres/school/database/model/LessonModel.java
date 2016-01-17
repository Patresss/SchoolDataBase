package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class LessonModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty number;
	private SimpleStringProperty startTime;
	private SimpleStringProperty duration;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public LessonModel(int id, String number, String startTime, String duration) {
		super(id);
		this.number = new SimpleStringProperty(number);
		this.startTime = new SimpleStringProperty(startTime);
		this.duration = new SimpleStringProperty(duration);
	}
	
	public LessonModel(String number, String startTime, String duration) {
		super();
		this.number = new SimpleStringProperty(number);
		this.startTime = new SimpleStringProperty(startTime);
		this.duration = new SimpleStringProperty(duration);
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public String getNumber() {
        return number.get();
    }
	
    public void setNumber(String n) {
    	number.set(n);
    }
    
	public String getStartTime() {
        return startTime.get();
    }
	
    public void setStartTime(String sTime) {
    	startTime.set(sTime);
    }
    
	public String getDuration() {
        return duration.get();
    }
	
    public void setDuration(String d) {
    	duration.set(d);
    }
	
}
