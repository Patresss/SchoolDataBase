package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.single.DutyConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;
import com.patres.school.gui.controller.content.Controllable;

public class EditDutyController extends AbstractEditSingle implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new DutyConnector();
		table = DatabaseTable.DUTY;
		initEditor();

		onlyDigitListner(textFieldMap.get("id_duty"));
		onlyDigitListner(textFieldMap.get("importance"));
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String dutyName = textFieldMap.get("duty_name").getText();
		int importance = Integer.parseInt(textFieldMap.get("importance").getText());

		if (isNumeric(textFieldMap.get("id_duty").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_duty").getText());
			return new Duty(id, dutyName, importance);
		} else {
			return new Duty(dutyName, importance);
		}
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		Duty duty = (Duty) model;
		if (duty != null) {
			textFieldMap.get("id_duty").setText(setNotNullString(duty.getId().toString()));
			textFieldMap.get("duty_name").setText(setNotNullString(duty.getDutyName()));
			textFieldMap.get("importance").setText(setNotNullString(duty.getImportance().toString()));
		}
	}

}
