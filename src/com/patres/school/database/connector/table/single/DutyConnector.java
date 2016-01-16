package com.patres.school.database.connector.table.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;

public class DutyConnector extends AbstractSingleConnector {

	
	// ================================================================================
	// Constructor
	// ================================================================================
	public DutyConnector() {
		super(DatabaseTable.DUTY);
	}
	
	// ================================================================================
	// Select Model SQL
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_duty");
		String dutyName = resultSet.getString("duty_name");
		Integer importance = resultSet.getInt("importance");
		
		return new Duty(id, dutyName, importance);
	}

	
	// ================================================================================
	// Get value from model
	// ================================================================================
	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) {
		Duty duty = (Duty) model;
		valueList.add(getSqlForm(duty.getDutyName()));
		valueList.add(getSqlForm(duty.getImportance()));
		return valueList;
	}

}
