package com.patres.school.gui.controller.content.edit;

import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.connector.table.StaffConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Staff;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

	@FXML
	private Label degreeLabel;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private JFXTextField degreeTextField;
	@FXML
	private JFXTextField firstNameTextField;
	@FXML
	private JFXTextField lastNameTextField;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new StaffConnector();
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

	@Override
	protected void initLabels() {
		degreeLabel.setText(Main.getBundle().getString("staff.degree") + ":");
		firstNameLabel.setText(Main.getBundle().getString("staff.firstName") + ":");
		lastNameLabel.setText(Main.getBundle().getString("staff.lastName") + ":");
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getNewModel() {
		String degree = degreeTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		Staff staff = new Staff(degree, firstName, lastName);
		return staff;
	}

	@Override
	protected AbstractModel getEditModel() {
		int id = getSelectedItem().getId();
		String degree = degreeTextField.getText();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		Staff staff = new Staff(id, degree, firstName, lastName);
		return staff;
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		Staff staff = (Staff) model;
		if (staff != null) {
			degreeTextField.setText(setNotNullString(staff.getDegree()));
			firstNameTextField.setText(setNotNullString(staff.getFirstName()));
			lastNameTextField.setText(setNotNullString(staff.getLastName()));
		}
	}

}
