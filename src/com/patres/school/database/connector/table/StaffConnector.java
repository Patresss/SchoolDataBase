package com.patres.school.database.connector.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Staff;

public class StaffConnector extends AbstractConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public StaffConnector() {
		super(DatabaseTable.STAFF);
	}

	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModel(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String degree = resultSet.getString("degree");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");

		return new Staff(id, degree, firstName, lastName);
	}

	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) throws SQLException {
		Staff staff = (Staff) model;
		valueList.add(getStringForm(staff.getDegree()));
		valueList.add(getStringForm(staff.getFirstName()));
		valueList.add(getStringForm(staff.getLastName()));
		return valueList;
	}

}
