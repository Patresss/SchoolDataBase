package com.patres.school.database.model;

import lombok.Getter;

public class StaffHasSubjectModel extends AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	@Getter
	private StaffModel staff;
	@Getter
	private SubjectModel subject;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public StaffHasSubjectModel(StaffModel staff, SubjectModel subject) {
		this.staff = staff;
		this.subject = subject;
	}
	

	
}
