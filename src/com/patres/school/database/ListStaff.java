package com.patres.school.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.Main;
import com.patres.school.hellper.MapStaffDuty;

public class ListStaff {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ListStaff.class);

	public void getTeacher() {
		String sql = "SELECT * FROM teacher_list;";
		try {
			ResultSet rs = Main.getStatement().executeQuery(sql);

			while (rs.next()) {
				
				String degree = rs.getString("degree");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String subject = rs.getString("name");

				System.out.print("degree: " + degree);
				System.out.print(", first_name: " + first_name);
				System.out.print(", last_name: " + last_name);
				System.out.println(", subject: " + subject);
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	public LinkedList<MapStaffDuty> getStaffWithoutTeacher() {
		String sql = "SELECT * FROM list_duty_staff;";
		LinkedList<MapStaffDuty> list = new LinkedList<MapStaffDuty>();
		try {
			ResultSet rs = Main.getStatement().executeQuery(sql);

			while (rs.next()) {
				String degree = rs.getString("degree");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String duty_name = rs.getString("duty_name");

				list.add(new MapStaffDuty(duty_name, degree + " " + first_name + " " +last_name));
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
		return list;
	}
}
