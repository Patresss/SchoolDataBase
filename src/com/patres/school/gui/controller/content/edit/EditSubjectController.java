package com.patres.school.gui.controller.content.edit;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.SubjectConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Subject;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditSubjectController extends AbstractEditController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableColumn<AbstractModel, String> idTableColumn;
	@FXML
	private TableColumn<AbstractModel, String> subjectNameTableColumn;

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
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		subjectNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("subjectName"));
		refreshTable();
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
