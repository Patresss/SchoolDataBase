package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.StaffConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Staff;
import com.patres.school.gui.controller.content.Controllable;

public class EditStaffController extends AbstractEditSingle implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new StaffConnector();
		table = DatabaseTable.STAFF;
		
		initEditor();
		onlyDigitListner(textFieldMap.get("id_staff"));
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String degree = textFieldMap.get("degree").getText();
		String firstName = textFieldMap.get("first_name").getText();
		String lastName = textFieldMap.get("last_name").getText();
		
		if (isNumeric(textFieldMap.get("id_staff").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_staff").getText());
			return new Staff(id, degree, firstName, lastName);
		} else {
			return new Staff(degree, firstName, lastName);
		}
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		Staff staff = (Staff) model;
		if (staff != null) {
			textFieldMap.get("id_staff").setText(setNotNullString(staff.getId().toString()));
			textFieldMap.get("degree").setText(setNotNullString(staff.getDegree()));
			textFieldMap.get("first_name").setText(setNotNullString(staff.getFirstName()));
			textFieldMap.get("last_name").setText(setNotNullString(staff.getLastName()));
		}
	}

}
