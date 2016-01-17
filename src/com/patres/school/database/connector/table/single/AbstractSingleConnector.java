package com.patres.school.database.connector.table.single;

import java.util.ArrayList;

import com.patres.school.database.connector.table.AbstractConnector;
import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;

public abstract class AbstractSingleConnector extends AbstractConnector {
	
	// ================================================================================
	// Constructor
	// ================================================================================
	public AbstractSingleConnector(DatabaseTable table) {
		super(table);
	}
	
	// ================================================================================
	// Others
	// ================================================================================
	@Override
	protected String getSelectSql() {
		return queryGenerator.getSelect();
	}
	@Override
	protected String getDeleteSql(AbstractModel model) {
		return queryGenerator.getDelete(model.getId());
	}

	@Override
	protected ArrayList<String> getValues(AbstractModel model) {
		ArrayList<String> list = new ArrayList<String>();
		
		if(model.getIdProperty() != null) {
			list.add(getSqlForm(model.getId()));
		}
		return getValuesFromModel(model, list);
	}
	
	protected abstract ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList);
	
}
