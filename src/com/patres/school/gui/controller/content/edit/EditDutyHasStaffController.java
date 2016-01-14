package com.patres.school.gui.controller.content.edit;

import com.jfoenix.controls.JFXComboBox;
import com.patres.school.Main;
import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.DutyConnector;
import com.patres.school.database.connector.table.DutyHasStaffConnector;
import com.patres.school.database.connector.table.StaffConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.DutyHasStaff;
import com.patres.school.gui.controller.content.Controllable;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditDutyHasStaffController extends AbstractEditController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableColumn<AbstractModel, String> dutyTableColumn;
	@FXML
	private TableColumn<AbstractModel, String> staffTableColumn;

	// ================================================================================
	// Properties
	// ================================================================================
	private JFXComboBox<AbstractModel> dutyComboBox;
	private JFXComboBox<AbstractModel> staffComboBox;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new DutyHasStaffConnector();
		table = DatabaseTable.DUTY_HAS_STAFF;

		initEditor();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		dutyTableColumn.setCellValueFactory(new PropertyValueFactory<>("duty"));
		staffTableColumn.setCellValueFactory(new PropertyValueFactory<>("staff"));
		refreshTable();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initEditGridPane() {
		dutyComboBox = new JFXComboBox<AbstractModel>();
		staffComboBox = new JFXComboBox<AbstractModel>();

		String dutyName = Main.getBundle().getString("duty.table");
		Label dutyLabel = new Label(dutyName + ":");
		dutyLabel.getStyleClass().add("label-text-field");

		DutyConnector dutyConnector = new DutyConnector();
		dutyComboBox.setItems(FXCollections.observableList(dutyConnector.select()));

		String staffName = Main.getBundle().getString("staff.table");
		Label staffLabel = new Label(staffName + ":");
		staffLabel.getStyleClass().add("label-text-field");

		StaffConnector staffConnector = new StaffConnector();
		staffComboBox.setItems(FXCollections.observableList(staffConnector.select()));

		editGridPane.add(dutyLabel, 0, 0);
		editGridPane.add(dutyComboBox, 1, 0);
		editGridPane.add(staffLabel, 0, 1);
		editGridPane.add(staffComboBox, 1, 1);

		dutyComboBox.setMinWidth(EDIT_PANE_WIDTH * 0.7);
		staffComboBox.setMinWidth(EDIT_PANE_WIDTH * 0.7);
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		return null;
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		DutyHasStaff dutyHasStaff = (DutyHasStaff) model;
		if (dutyHasStaff != null) {
			dutyComboBox.setValue(dutyHasStaff.getDuty());
			staffComboBox.setValue(dutyHasStaff.getStaff());
		}
	}

}
