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
	ROOM("room"),
	STAFF("staff"),
	SUBJECT("subject"),
	DUTY("duty"),
	STAFF_HAS_DUTY("staff_has_duty");
	
	// ================================================================================
	// Properties
	// ================================================================================
	private String tableName;
	private ArrayList<String> columnName;
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseTable.class);

	// ================================================================================
	// Constructor
	// ================================================================================
	DatabaseTable(String tableName) {
		this.tableName = tableName;
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
	
	public ArrayList<String> getColumn() {
		return columnName;
	}
	
	public ArrayList<String> getColumnWithoutId() {
		return new ArrayList<String>(columnName.subList(1, columnName.size()));
	}
	
	
}
