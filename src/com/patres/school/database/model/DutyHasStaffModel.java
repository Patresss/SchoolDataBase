package com.patres.school.database.model;

import lombok.Getter;

public class DutyHasStaffModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	@Getter
	private StaffModel staff;
	@Getter
	private DutyModel duty;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public DutyHasStaffModel(DutyModel duty, StaffModel staff) {
		this.staff = staff;
		this.duty = duty;
	}
	

	
}
