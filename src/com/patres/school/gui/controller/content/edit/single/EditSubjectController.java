package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.single.SubjectConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Subject;
import com.patres.school.gui.controller.content.Controllable;

public class EditSubjectController extends AbstractEditSingle implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new SubjectConnector();
		table = DatabaseTable.SUBJECT;
		
		initEditor();
		onlyDigitListner(textFieldMap.get("id_subject"));
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String subjectName = textFieldMap.get("subject_name").getText();
		if (isNumeric(textFieldMap.get("id_subject").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_subject").getText());
			return new Subject(id, subjectName);
		} else {
			return new Subject(subjectName);
		}
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		Subject subject = (Subject) model;
		if (subject != null) {
			textFieldMap.get("id_subject").setText(setNotNullString(subject.getId().toString()));
			textFieldMap.get("subject_name").setText(setNotNullString(subject.getSubjectName()));
		}
	}

}
