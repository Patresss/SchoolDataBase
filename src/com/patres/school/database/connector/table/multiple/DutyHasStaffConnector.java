package com.patres.school.database.connector.table.multiple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.DutyModel;
import com.patres.school.database.model.DutyHasStaffModel;
import com.patres.school.database.model.StaffModel;

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
		String importance = resultSet.getString("importance");
		DutyModel duty = new DutyModel(id, dutyName, importance);

		int idStaff = resultSet.getInt("id_staff");
		String degree = resultSet.getString("degree");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		StaffModel staff = new StaffModel(idStaff, degree, firstName, lastName);

		return new DutyHasStaffModel(duty, staff);
	}

	@Override
	protected ArrayList<String> getValues(AbstractModel model) {
		DutyHasStaffModel dhs = (DutyHasStaffModel) model;
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(getSqlForm(dhs.getDuty().getId()));
		list.add(getSqlForm(dhs.getStaff().getId()));
		
		return list;
	}
	
	@Override
	protected ArrayList<Integer> getDeletedId(AbstractModel model) {
		DutyHasStaffModel dutyHasStaff = (DutyHasStaffModel) model;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(dutyHasStaff.getDuty().getId());
		ids.add(dutyHasStaff.getStaff().getId());
		return ids;
	}


}
