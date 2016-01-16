package com.patres.school.database.connector.table.multiple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;
import com.patres.school.database.model.DutyHasStaff;
import com.patres.school.database.model.Staff;

public class DutyHasStaffConnector extends AbstractMultipleConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public DutyHasStaffConnector() {
		super(DatabaseTable.DUTY_HAS_STAFF);
	}

	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_duty");
		String dutyName = resultSet.getString("duty_name");
		Integer importance = resultSet.getInt("importance");
		Duty duty = new Duty(id, dutyName, importance);

		int idStaff = resultSet.getInt("id_staff");
		String degree = resultSet.getString("degree");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		Staff staff = new Staff(idStaff, degree, firstName, lastName);

		return new DutyHasStaff(duty, staff);
	}

	@Override
	protected ArrayList<String> getValues(AbstractModel model) {
		DutyHasStaff dhs = (DutyHasStaff) model;
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(getSqlForm(dhs.getDuty().getId()));
		list.add(getSqlForm(dhs.getStaff().getId()));
		
		return list;
	}


}
