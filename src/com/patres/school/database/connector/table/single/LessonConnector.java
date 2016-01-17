package com.patres.school.database.connector.table.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.LessonModel;

public class LessonConnector extends AbstractSingleConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public LessonConnector() {
		super(DatabaseTable.LESSON);
	}

	// ================================================================================
	// Select Model SQL
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_lesson");
		String number = resultSet.getString("number");
		String startTime = resultSet.getString("start_time");
		String dyration = resultSet.getString("duration");

		return new LessonModel(id, number, startTime, dyration);
	}

	// ================================================================================
	// Get value from model
	// ================================================================================
	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) {
		LessonModel lesson = (LessonModel) model;
		valueList.add(getSqlForm(lesson.getNumber()));
		valueList.add(getSqlForm(lesson.getStartTime()));
		valueList.add(getSqlForm(lesson.getDuration()));
		return valueList;
	}

}
