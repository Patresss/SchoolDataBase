package com.patres.school.database.connector.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.QueryGenerator;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;

public class DutyConnector extends AbstractConnector {

	private static QueryGenerator queryGenerator = new QueryGenerator(DatabaseTable.DUTY);
	
	// ================================================================================
	// Constructor
	// ================================================================================
	public DutyConnector() {
		super();
	}
	
	@Override
	public QueryGenerator getQueryGenerator() {
		return queryGenerator;
	}
	
	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModel(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_duty");
		String dutyName = resultSet.getString("duty_name");
		Integer importance = resultSet.getInt("importance");
		
		return new Duty(id, dutyName, importance);
	}

	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) throws SQLException {
		Duty subject = (Duty) model;
		valueList.add(getSqlForm(subject.getDutyName()));
		valueList.add(getSqlForm(subject.getImportance()));
		return valueList;
	}

}
