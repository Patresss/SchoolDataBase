package com.patres.school.gui.controller.content.edit;

import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.connector.table.SubjectConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Subject;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditSubjectController extends AbstractEditController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	

	@FXML
	private Label subjectNameLabel;
	@FXML
	private JFXTextField subjectNameTextField;
	@FXML
	private TableColumn<AbstractModel, String> subjectNameTableColumn;
	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new SubjectConnector();
		initEditor();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		System.out.println(idTableColumn);
		System.out.println(subjectNameTableColumn);
		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		subjectNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
		
		refreshTable();
	}

	@Override
	protected void initLabels() {
		subjectNameLabel.setText(Main.getBundle().getString("subject.name") + ":");
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getNewModel() {
		String subjectName = subjectNameTextField.getText();
		Subject subject = new Subject(subjectName);
		return subject;
	}

	@Override
	protected AbstractModel getEditModel() {
		int id = getSelectedItem().getId();
		String subjectName = subjectNameTextField.getText();
		Subject subject = new Subject(id, subjectName);
		return subject;
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		Subject subject = (Subject) model;
		if (subject != null) {
			subjectNameTextField.setText(setNotNullString(subject.getSubjectName()));
		}
	}

}
