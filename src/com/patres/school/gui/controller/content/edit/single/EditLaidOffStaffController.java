package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.single.LaidOffStaffConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.LaidOffStaffModel;
import com.patres.school.gui.controller.content.Controllable;

public class EditLaidOffStaffController extends AbstractEditSingle implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new LaidOffStaffConnector();
		table = DatabaseTable.LAID_OFF_STAFF;
		
		initEditor();
		onlyDigitListner(textFieldMap.get("id_laid_off_staff"));
		textFieldMap.values().stream().forEach((a) -> a.setDisable(true));
	}
	
	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initButons() {
	}

	@Override
	protected void initSizeGridePane() {
		editGridPane.setMinWidth(EDIT_PANE_WIDTH);
		removeButton.setPrefWidth(EDIT_PANE_WIDTH);
		buttonGridPane.setMaxWidth(EDIT_PANE_WIDTH);
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String degree = textFieldMap.get("degree").getText();
		String firstName = textFieldMap.get("first_name").getText();
		String lastName = textFieldMap.get("last_name").getText();
		
		if (isNumeric(textFieldMap.get("id_laid_off_staff").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_laid_off_staff").getText());
			return new LaidOffStaffModel(id, degree, firstName, lastName);
		} else {
			return new LaidOffStaffModel(degree, firstName, lastName);
		}
	}

	// ================================================================================
	// Listener
	// ================================================================================
	@Override
	protected void selectedListner() {
		modelTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue != null) {
				showDetails(newValue);
			} 
		});
	}
	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		LaidOffStaffModel staff = (LaidOffStaffModel) model;
		if (staff != null) {
			textFieldMap.get("id_laid_off_staff").setText(setNotNullString(staff.getId().toString()));
			textFieldMap.get("degree").setText(setNotNullString(staff.getDegree()));
			textFieldMap.get("first_name").setText(setNotNullString(staff.getFirstName()));
			textFieldMap.get("last_name").setText(setNotNullString(staff.getLastName()));
		}
	}

}
