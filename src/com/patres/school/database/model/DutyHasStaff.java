package com.patres.school.database.model;

import lombok.Getter;

public class DutyHasStaff extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	@Getter
	private Staff staff;
	@Getter
	private Duty duty;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public DutyHasStaff(Duty duty, Staff staff) {
		this.staff = staff;
		this.duty = duty;
	}
	

	
}
