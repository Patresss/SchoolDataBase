package com.patres.school.database.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Room extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty roomName;
	private SimpleIntegerProperty limitPeople;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public Room(int id, String roomName, int limitPeople) {
		super(id);
		this.roomName = new SimpleStringProperty(roomName);
		this.limitPeople = new SimpleIntegerProperty(limitPeople);
	}
	
	public Room(String roomName, int limitPeople) {
		super();
		this.roomName = new SimpleStringProperty(roomName);
		this.limitPeople = new SimpleIntegerProperty(limitPeople);
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public String getRoomName() {
        return roomName.get();
    }
	
    public void setRoomName(String name) {
    	roomName.set(name);
    }
    
	public Integer getLimitPeople() {
        return limitPeople.get();
    }
	
    public void setLimitPeople(Integer limt) {
    	limitPeople.set(limt);
    }
	
}
