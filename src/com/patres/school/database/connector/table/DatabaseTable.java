package com.patres.school.database.connector.table;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.Main;

public enum DatabaseTable {

	// ================================================================================
	// Table
	// ================================================================================
	ROOM("room", RoomConnector.class),
	STAFF("staff", StaffConnector.class),
	SUBJECT("subject", SubjectConnector.class),
	DUTY("duty", DutyConnector.class),
	DUTY_HAS_STAFF("duty_has_staff", DutyHasStaffConnector.class);
	
	// ================================================================================
	// Properties
	// ================================================================================
	private String tableName;
	private Class<? extends AbstractConnector> connector;
	private ArrayList<String> columnName;
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseTable.class);

	// ================================================================================
	// Constructor
	// ================================================================================
	DatabaseTable(String tableName, Class<? extends AbstractConnector> connector) {
		this.tableName = tableName;
		this.connector = (Class<? extends AbstractConnector>) connector;
		setColumnsName();
	}

	private void setColumnsName() {
		columnName = new ArrayList<String>();
		DatabaseMetaData meta = null;
		try {
			meta = Main.getConnection().getMetaData();
			ResultSet resultSet = meta.getColumns(null, null, tableName, null);
			while (resultSet.next()) {
				String name = resultSet.getString("COLUMN_NAME");
				columnName.add(name);
			}
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public String getTableName() {
		return tableName;
	}
	
	public AbstractConnector getConnector() {
		try {
			return connector.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<String> getColumn() {
		return columnName;
	}
	
	public ArrayList<String> getColumnWithoutId() {
		return new ArrayList<String>(columnName.subList(1, columnName.size()));
	}
	
	
}
