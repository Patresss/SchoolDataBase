package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.single.ClassConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.ClassModel;
import com.patres.school.gui.controller.content.Controllable;

public class EditClassController extends AbstractEditSingle  implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new ClassConnector();
		table = DatabaseTable.CLASS;
		initEditor();
		
		onlyDigitListner(textFieldMap.get("id_class"));
		onlyDigitListner(textFieldMap.get("people_count"));
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String year = textFieldMap.get("year").getText();
		
		String letterClass = textFieldMap.get("letter_class").getText();
		
		String peopleCount = textFieldMap.get("people_count").getText();

		
		if (isNumeric(textFieldMap.get("id_class").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_class").getText());
			return new ClassModel(id, year, letterClass, peopleCount);
		} else {
			return new ClassModel(year, letterClass, peopleCount);
		}
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		ClassModel classModel = (ClassModel) model;
		if (classModel != null) {
			textFieldMap.get("id_class").setText(setNotNullString(classModel.getId().toString()));
			textFieldMap.get("year").setText(setNotNullString(classModel.getYear().toString()));
			textFieldMap.get("letter_class").setText(setNotNullString(classModel.getLetterClass()));
			textFieldMap.get("people_count").setText(setNotNullString(classModel.getPeopleCount().toString()));
		}
	}

}
