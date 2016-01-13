package com.patres.school.database.connector.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Subject;

public class SubjectConnector extends AbstractConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public SubjectConnector() {
		super(DatabaseTable.SUBJECT);
	}

	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModel(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String subjectName = resultSet.getString("subject_name");

		return new Subject(id, subjectName);
	}

	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model,ArrayList<String> valueList) throws SQLException {
		Subject subject = (Subject) model;
		valueList.add(getStringForm(subject.getSubjectName()));
		return valueList;
	}
	
}
