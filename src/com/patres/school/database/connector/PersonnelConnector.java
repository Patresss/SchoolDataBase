package com.patres.school.database.connector;

import java.util.LinkedList;

public class PersonnelConnector extends TeachingStaffConnector {

	public LinkedList<String> getSpecificHeader() {
		String sql = "SELECT duty_name FROM list_duty;";
		String column = "duty_name";
		return getHeader(sql, column);
	}
	
	public LinkedList<String> getSpecificStaff(String header) {
		String sql = "SELECT degree, first_name, last_name, duty_name FROM list_duty_staff WHERE duty_name='" + header + "';";
		return getStaff(header, sql);
	}
}
