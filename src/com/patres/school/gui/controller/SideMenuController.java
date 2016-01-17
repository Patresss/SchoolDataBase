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
	@FXML private Label editRoomLabel;
	@FXML private Label editStaffLabel;
	@FXML private Label editLaidOffStaffLabel;
	@FXML private Label editSubjectLabel;
	@FXML private Label editDutyLabel;
	@FXML private Label editClassLabel;
	@FXML private Label editLessonLabel;
	@FXML private Label editDutyHasStaffLabel;
	@FXML private Label editStaffHasSubjectLabel;
	@FXML private Label statisticLabel;
	@FXML private JFXListView<?> sideList;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		welcomeLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.WELCOME);
		});
		
		editRoomLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_ROOM);
		});
		editStaffLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_STAFF);
		});
		editLaidOffStaffLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_LAID_OFF_STAFF);
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
		
		statisticLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.STATICTIC);
		});
	}

}
