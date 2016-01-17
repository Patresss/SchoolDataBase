package com.patres.school.database.model;

import javafx.beans.property.SimpleStringProperty;

public class RoomModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleStringProperty roomName;
	private SimpleStringProperty limitPeople;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public RoomModel(int id, String roomName, String limitPeople) {
		super(id);
		this.roomName = new SimpleStringProperty(roomName);
		this.limitPeople = new SimpleStringProperty(limitPeople);
	}
	
	public RoomModel(String roomName, String limitPeople) {
		super();
		this.roomName = new SimpleStringProperty(roomName);
		this.limitPeople = new SimpleStringProperty(limitPeople);
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
    
	public String getLimitPeople() {
        return limitPeople.get();
    }
	
    public void setLimitPeople(String limt) {
    	limitPeople.set(limt);
    }
	
}
