package com.patres.school.gui.controller.content.edit;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.DutyConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditDutyController extends AbstractEditController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableColumn<AbstractModel, String> nameTableColumn;
	@FXML
	private TableColumn<AbstractModel, Integer> importanceTableColumn;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new DutyConnector();
		table = DatabaseTable.DUTY;
		initEditor();
		onlyDigitListner(textFieldMap.get("importance"));
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("dutyName"));
		importanceTableColumn.setCellValueFactory(new PropertyValueFactory<>("importance"));
		refreshTable();
	}
	
	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String dutyName = textFieldMap.get("duty_name").getText();
		int importance = Integer.parseInt(textFieldMap.get("importance").getText());
		
		if (isNumeric(textFieldMap.get("id").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id").getText());
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
			textFieldMap.get("id").setText(setNotNullString(duty.getId().toString()));
			textFieldMap.get("duty_name").setText(setNotNullString(duty.getDutyName()));
			textFieldMap.get("importance").setText(setNotNullString(duty.getImportance().toString()));
		}
	}

}
