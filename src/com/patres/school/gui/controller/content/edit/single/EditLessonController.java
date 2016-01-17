package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.single.LessonConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.LessonModel;
import com.patres.school.gui.controller.content.Controllable;

public class EditLessonController extends AbstractEditSingle  implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new LessonConnector();
		table = DatabaseTable.LESSON;
		initEditor();
		
		onlyDigitListner(textFieldMap.get("id_lesson"));
		onlyDigitListner(textFieldMap.get("number"));
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String number = textFieldMap.get("number").getText();
		String startTime = textFieldMap.get("start_time").getText();
		String duration = textFieldMap.get("duration").getText();

		if (isNumeric(textFieldMap.get("id_lesson").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_lesson").getText());
			return new LessonModel(id, number, startTime, duration);
		} else {
			return new LessonModel(number, startTime, duration);
		}
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		LessonModel classModel = (LessonModel) model;
		if (classModel != null) {
			textFieldMap.get("id_lesson").setText(setNotNullString(classModel.getId().toString()));
			textFieldMap.get("number").setText(setNotNullString(classModel.getNumber()));
			textFieldMap.get("start_time").setText(setNotNullString(classModel.getStartTime()));
			textFieldMap.get("duration").setText(setNotNullString(classModel.getDuration()));
		}
	}

}
