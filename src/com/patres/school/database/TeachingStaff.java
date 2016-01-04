package com.patres.school.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.Main;

public abstract class TeachingStaff {

	private static final Logger LOGGER = LoggerFactory.getLogger(TeachingStaff.class);
	
	public abstract LinkedList<String> getSpecificHeader();
	public abstract LinkedList<String> getSpecificStaff(String header);
	
	protected LinkedList<String> getHeader(String sql, String column) {
		LinkedList<String> list = new LinkedList<String>();
		try {
			ResultSet resultSet = Main.getStatement().executeQuery(sql);

			while (resultSet.next()) {
				String header_name = resultSet.getString(column);
				list.add(header_name);
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
		return list;
	}
	
	public LinkedList<String> getStaff(String header, String sql) {
		LinkedList<String> list = new LinkedList<String>();
		try {
			ResultSet resultSet = Main.getStatement().executeQuery(sql);

			while (resultSet.next()) {
				String degree = resultSet.getString("degree");
				String first_name = resultSet.getString("first_name");
				String last_name = resultSet.getString("last_name");
				list.add(degree + " " + first_name + " " + last_name);
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
		return list;
	}
	

}
