package com.patres.school.gui.controller.content.edit.multiple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.multiple.StaffHasSubjectConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.StaffModel;
import com.patres.school.database.model.StaffHasSubjectModel;
import com.patres.school.database.model.SubjectModel;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class EditStaffHasSubjectController extends AbstractEditMultipleController implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		databaseTableList = new LinkedList<DatabaseTable>();
		databaseTableList.add(DatabaseTable.STAFF);
		databaseTableList.add(DatabaseTable.SUBJECT);
		
		comboBoxMap = new HashMap<String, ComboBox<AbstractModel>>(); 
		
		connector = new StaffHasSubjectConnector();
		table = DatabaseTable.STAFF_HAS_SUBJECT;
		
		initEditor();
	}

	// ================================================================================
	// FXML methods
	// ================================================================================
	@FXML 
	protected void editModel() {
		((StaffHasSubjectConnector) connector).update(getModel(), getSelectedIds());
		refreshTable();
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		StaffModel staff = (StaffModel) comboBoxMap.get("staff").getValue();
		SubjectModel subject = (SubjectModel) comboBoxMap.get("subject").getValue();
		return new StaffHasSubjectModel(staff, subject);
	}
	
	protected ArrayList<Integer> getSelectedIds() {
		StaffHasSubjectModel model = (StaffHasSubjectModel) getSelectedItem();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(model.getStaff().getId());
		ids.add(model.getSubject().getId());
		return ids;
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		StaffHasSubjectModel staffHasSubject = (StaffHasSubjectModel) model;
		 if (staffHasSubject != null) {
		 comboBoxMap.get("staff").setValue(staffHasSubject.getStaff());
		 comboBoxMap.get("subject").setValue(staffHasSubject.getSubject());
		 }
	}
	
	//TODO make for all 
	protected ArrayList<Integer> getIdsToEdit() {
		StaffHasSubjectModel model = (StaffHasSubjectModel) getSelectedItem();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(model.getStaff().getId());
		ids.add(model.getSubject().getId());
		return ids;
	}

}
