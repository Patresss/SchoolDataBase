package com.patres.school.gui.controller.content.edit.multiple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.multiple.DutyHasStaffConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;
import com.patres.school.database.model.DutyHasStaff;
import com.patres.school.database.model.Staff;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class EditDutyHasStaffController extends AbstractEditMultipleController implements Controllable {


	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		databaseTableList = new LinkedList<DatabaseTable>();
		databaseTableList.add(DatabaseTable.DUTY);
		databaseTableList.add(DatabaseTable.STAFF);
		
		comboBoxMap = new HashMap<String, ComboBox<AbstractModel>>(); 
		
		connector = new DutyHasStaffConnector();
		table = DatabaseTable.DUTY_HAS_STAFF;
		
		initEditor();
	}

	// ================================================================================
	// FXML methods
	// ================================================================================
	@FXML 
	protected void editModel() {
		((DutyHasStaffConnector) connector).update(getModel(), getSelectedIds());
		refreshTable();
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		Staff staff = (Staff) comboBoxMap.get("staff").getValue();
		Duty duty = (Duty) comboBoxMap.get("duty").getValue();
		return new DutyHasStaff(duty, staff);
	}
	
	protected ArrayList<Integer> getSelectedIds() {
		DutyHasStaff model = (DutyHasStaff) getSelectedItem();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(model.getDuty().getId());
		ids.add(model.getStaff().getId());
		return ids;
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		 DutyHasStaff dutyHasStaff = (DutyHasStaff) model;
		 if (dutyHasStaff != null) {
		 comboBoxMap.get("duty").setValue(dutyHasStaff.getDuty());
		 comboBoxMap.get("staff").setValue(dutyHasStaff.getStaff());
		 }
	}
	
	//TODO make for all 
	protected ArrayList<Integer> getIdsToEdit() {
		DutyHasStaff model = (DutyHasStaff) getSelectedItem();
		ArrayList<Integer> ids = new ArrayList<Integer>();
		ids.add(model.getDuty().getId());
		ids.add(model.getStaff().getId());
		return ids;
	}

}
