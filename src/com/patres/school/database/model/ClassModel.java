package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class ClassModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty year;
	private SimpleStringProperty letterClass;
	private SimpleStringProperty peopleCount;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public ClassModel(int id, String year, String letterClass, String peopleCount) {
		super(id);
		this.year = new SimpleStringProperty(year);
		this.letterClass = new SimpleStringProperty(letterClass);
		this.peopleCount = new SimpleStringProperty(peopleCount);
	}
	
	public ClassModel(String year, String letterClass, String peopleCount) {
		super();
		this.year = new SimpleStringProperty(year);
		this.letterClass = new SimpleStringProperty(letterClass);
		this.peopleCount = new SimpleStringProperty(peopleCount);
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public String getYear() {
        return year.get();
    }
	
    public void setYear(String y) {
    	year.set(y);
    }
    
	public String getLetterClass() {
        return letterClass.get();
    }
	
    public void setLetterClass(String letter) {
    	letterClass.set(letter);
    }
    
	public String getPeopleCount() {
        return peopleCount.get();
    }
	
    public void setPeopleCount(String count) {
    	peopleCount.set(count);
    }
	
}
