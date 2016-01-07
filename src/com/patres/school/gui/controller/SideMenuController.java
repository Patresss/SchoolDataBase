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
	@FXML private Label addRoomLabel;
	@FXML private Label editRoomLabel;
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
		
		addRoomLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.ADD_ROOM);
		});
		
		editRoomLabel.setOnMouseClicked((e) -> {
			PaneSetter.loadNewContent(SchoolPane.EDIT_ROOM);
		});
	}

}
