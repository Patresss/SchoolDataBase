package com.patres.school.database.connector.table.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.SubjectModel;

public class SubjectConnector extends AbstractSingleConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public SubjectConnector() {
		super(DatabaseTable.SUBJECT);
	}

	// ================================================================================
	// Select Model SQL
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_subject");
		String subjectName = resultSet.getString("subject_name");

		return new SubjectModel(id, subjectName);
	}

	// ================================================================================
	// Get value from model
	// ================================================================================
	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model,ArrayList<String> valueList) {
		SubjectModel subject = (SubjectModel) model;
		valueList.add(getSqlForm(subject.getSubjectName()));
		return valueList;
	}
	
}
