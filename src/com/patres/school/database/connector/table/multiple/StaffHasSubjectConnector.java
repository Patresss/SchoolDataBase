package com.patres.school.database.connector.table.multiple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.StaffModel;
import com.patres.school.database.model.StaffHasSubjectModel;
import com.patres.school.database.model.SubjectModel;

public class StaffHasSubjectConnector extends AbstractMultipleConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public StaffHasSubjectConnector() {
		super(DatabaseTable.STAFF_HAS_SUBJECT);
	}

	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int idStaff = resultSet.getInt("id_staff");
		String degree = resultSet.getString("degree");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		StaffModel staff = new StaffModel(idStaff, degree, firstName, lastName);
		
		int id = resultSet.getInt("id_subject");
		String subjectName = resultSet.getString("subject_name");
		SubjectModel subject = new SubjectModel(id, subjectName);

		return new StaffHasSubjectModel(staff, subject);
	}

	@Override
	protected ArrayList<String> getValues(AbstractModel model) {
		StaffHasSubjectModel shs = (StaffHasSubjectModel) model;
		ArrayList<String> list = new ArrayList<String>();
		
		list.add(getSqlForm(shs.getStaff().getId()));
		list.add(getSqlForm(shs.getSubject().getId()));
		
		return list;
	}
	
	@Override
	protected ArrayList<Integer> getDeletedId(AbstractModel model) {
		StaffHasSubjectModel shs = (StaffHasSubjectModel) model;
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(shs.getStaff().getId());
		ids.add(shs.getSubject().getId());
		return ids;
	}


}
