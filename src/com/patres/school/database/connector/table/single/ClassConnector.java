package com.patres.school.database.connector.table.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.ClassModel;

public class ClassConnector extends AbstractSingleConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public ClassConnector() {
		super(DatabaseTable.CLASS);
	}

	// ================================================================================
	// Select Model SQL
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_class");
		String year = resultSet.getString("year");
		String letterClass = resultSet.getString("letter_class");
		String peopleCount = resultSet.getString("people_count");

		return new ClassModel(id, year, letterClass, peopleCount);
	}

	// ================================================================================
	// Get value from model
	// ================================================================================
	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) {
		ClassModel classModel = (ClassModel) model;
		valueList.add(getSqlForm(classModel.getYear()));
		valueList.add(getSqlForm(classModel.getLetterClass()));
		valueList.add(getSqlForm(classModel.getPeopleCount()));
		return valueList;
	}

}
