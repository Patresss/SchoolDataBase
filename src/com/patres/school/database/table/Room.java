package com.patres.school.database.table;

import lombok.Getter;

public class Room {

	@Getter
	private String roomName;
	@Getter
	private int limitPeople;
	
	public Room(String roomName, int limitPeople) {
		this.roomName = roomName;
		this.limitPeople = limitPeople;
	}
	
	
}
