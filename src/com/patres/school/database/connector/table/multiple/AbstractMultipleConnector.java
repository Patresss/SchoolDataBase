package com.patres.school.database.connector.table.multiple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.AbstractConnector;
import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;

public abstract class AbstractMultipleConnector extends AbstractConnector {
	
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
	
	@Override
	protected String getDeleteSql(AbstractModel model) {
		return queryGenerator.getDelete(getDeletedId(model));
	}
	
	
	protected abstract AbstractModel selectModelSql(ResultSet resultSet) throws SQLException;
	protected abstract ArrayList<Integer> getDeletedId(AbstractModel model);


}
