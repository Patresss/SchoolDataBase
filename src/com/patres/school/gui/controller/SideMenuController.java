package com.patres.school.gui.controller;

import com.jfoenix.controls.JFXListView;
import com.patres.school.gui.helper.PaneSetter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SideMenuController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML private Label welcomeLabel;
	@FXML private Label listTeacherLabel;
	@FXML private Label listRoomLabel;
	@FXML private Label editRoomLabel;
	@FXML private Label editStaffLabel;
	@FXML private Label editSubjectLabel;
	@FXML private Label editDutyLabel;
	@FXML private Label editClassLabel;
	@FXML private Label editLessonLabel;
	@FXML private Label editDutyHasStaffLabel;
	@FXML private Label editStaffHasSubjectLabel;
	@FXML private JFXListView<?> sideList;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		welcomeLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.WELCOME);
		});
		
		listTeacherLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.LIST_TEACHER);
		});
		
		listRoomLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.LIST_ROOM);
		});
		
		
		editRoomLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_ROOM);
		});
		editStaffLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_STAFF);
		});
		editSubjectLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_SUBJECT);
		});
		editDutyLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_DUTY);
		});
		editClassLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_CLASS);
		});
		editLessonLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_LESSON);
		});
		editDutyHasStaffLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_DUTY_HAS_STAFF);
		});
		editStaffHasSubjectLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_STAFF_HAS_SUBJECT);
		});
	}

}
