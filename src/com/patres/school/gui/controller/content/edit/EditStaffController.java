package com.patres.school.gui.controller.content.edit;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.StaffConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Staff;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditStaffController extends AbstractEditController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableColumn<AbstractModel, String> degreeTableColumn;
	@FXML
	private TableColumn<AbstractModel, String> firstNameTableColumn;
	@FXML
	private TableColumn<AbstractModel, String> lastNameTableColumn;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new StaffConnector();
		table = DatabaseTable.STAFF;
		
		initEditor();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		degreeTableColumn.setCellValueFactory(new PropertyValueFactory<>("degree"));
		firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		refreshTable();
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String degree = textFieldMap.get("degree").getText();
		String firstName = textFieldMap.get("first_name").getText();
		String lastName = textFieldMap.get("last_name").getText();
		
		if (isNumeric(textFieldMap.get("id").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id").getText());
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
			textFieldMap.get("id").setText(setNotNullString(staff.getId().toString()));
			textFieldMap.get("degree").setText(setNotNullString(staff.getDegree()));
			textFieldMap.get("first_name").setText(setNotNullString(staff.getFirstName()));
			textFieldMap.get("last_name").setText(setNotNullString(staff.getLastName()));
		}
	}

}
