package com.patres.school.database.connector.table.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.StaffModel;

public class StaffConnector extends AbstractSingleConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public StaffConnector() {
		super(DatabaseTable.STAFF);
	}

	// ================================================================================
	// Select Model SQL
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_staff");
		String degree = resultSet.getString("degree");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");

		return new StaffModel(id, degree, firstName, lastName);
	}

	// ================================================================================
	// Get value from model
	// ================================================================================
	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) {
		StaffModel staff = (StaffModel) model;
		valueList.add(getSqlForm(staff.getDegree()));
		valueList.add(getSqlForm(staff.getFirstName()));
		valueList.add(getSqlForm(staff.getLastName()));
		return valueList;
	}
	


}
