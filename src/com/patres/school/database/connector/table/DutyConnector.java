package com.patres.school.database.connector.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;

public class DutyConnector extends AbstractConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public DutyConnector() {
		super(DatabaseTable.DUTY);
	}

	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModel(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String dutyName = resultSet.getString("duty_name");
		Integer validity = resultSet.getInt("importance");
		
		return new Duty(id, dutyName, validity);
	}

	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) throws SQLException {
		Duty subject = (Duty) model;
		valueList.add(getSqlForm(subject.getDutyName()));
		valueList.add(getSqlForm(subject.getImportance()));
		return valueList;
	}
	
}
