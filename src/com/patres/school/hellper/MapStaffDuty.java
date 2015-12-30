package com.patres.school.hellper;

import lombok.Data;

@Data
public class MapStaffDuty {
	
	private String duty;
	private String person;
	
	
	public MapStaffDuty(String duty, String person) {
		super();
		this.duty = duty;
		this.person = person;
	}

}
