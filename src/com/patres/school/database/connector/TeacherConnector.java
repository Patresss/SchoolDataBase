package com.patres.school.database.connector;

import java.util.LinkedList;

public class TeacherConnector extends TeachingStaffConnector {

	public LinkedList<String> getSpecificHeader() {
		String sql = "SELECT subject_name FROM subject;";
		String column = "subject_name";
		return getHeader(sql, column);
	}
	
	public LinkedList<String> getSpecificStaff(String header) {
		String sql = "SELECT degree, first_name, last_name, subject_name FROM teacher_list WHERE subject_name='" + header + "';";
		return getStaff(header, sql);
	}
}
