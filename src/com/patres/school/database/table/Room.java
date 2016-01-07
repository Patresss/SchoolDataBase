package com.patres.school.database.table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Room {

	private SimpleIntegerProperty id;
	private SimpleStringProperty roomName;
	private SimpleIntegerProperty limitPeople;
	
	public Room(int id, String roomName, int limitPeople) {
		this.id = new SimpleIntegerProperty(id);
		this.roomName = new SimpleStringProperty(roomName);
		this.limitPeople = new SimpleIntegerProperty(limitPeople);
	}
	
	public Integer getId() {
        return id.get();
    }
	
    public void setId(Integer idRoom) {
    	id.set(idRoom);
    }
    
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
