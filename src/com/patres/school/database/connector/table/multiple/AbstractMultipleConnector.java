package com.patres.school.database.connector.table.multiple;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.database.connector.table.AbstractConnector;
import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.gui.controller.content.edit.AbstractEditController;

public abstract class AbstractMultipleConnector extends AbstractConnector {
	
	// ================================================================================
	// Properties
	// ================================================================================
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractEditController.class);

	// ================================================================================
	// Constructor
	// ================================================================================
	public AbstractMultipleConnector(DatabaseTable table) {
		super(table);
	}
	
	// ================================================================================
	// Others
	// ================================================================================
	@Override
	protected String getSelectSql() {
		return queryGenerator.getSelectView();
	}
	
	abstract protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException;



}
