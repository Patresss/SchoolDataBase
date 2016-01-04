package com.patres.school.gui.controller.content;

import java.util.LinkedList;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.patres.school.database.Personnel;
import com.patres.school.database.Teacher;
import com.patres.school.database.TeachingStaff;
import com.patres.school.hellper.MapStaffDuty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class ListTeacherController extends AbstractController {

	@FXML
	private VBox staffSchoolVBox;
	@FXML
	private VBox teacherVBox;
	
	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {

		initComponents();
	}
	
	private void initComponents() {
		
		initStaffSchoolVBox();
		initTeacherVBox();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	private void initStaffSchoolVBox() {
		TeachingStaff teachingStaff = new Personnel();
		initTeachingStaff(teachingStaff, staffSchoolVBox);
	}
	
	private void initTeacherVBox() {
		TeachingStaff teachingStaff = new Teacher();
		initTeachingStaff(teachingStaff, teacherVBox);
	}
	
	private void initTeachingStaff(TeachingStaff teachingStaff, VBox vBox) {
		LinkedList<String> headerList = teachingStaff.getSpecificHeader();

		for (String header : headerList) {
			JFXListView<String> staffListView = new JFXListView<String>();
			LinkedList<String> staffList = teachingStaff.getSpecificStaff(header);
			if(staffList.isEmpty()) {
				continue;
			}
			
			ObservableList<String> items = FXCollections.observableArrayList(staffList);
			staffListView.setItems(items);
			changeItem(staffListView);
			
			Label subjectLabel = new Label(header + ":");
			subjectLabel.getStyleClass().add("label-staff-header");
			
			vBox.getChildren().addAll(subjectLabel, staffListView);
		}
	}
	
	
	
	private void changeItem(JFXListView<String> list) {
		list.setMinWidth(500);
		list.setOpacity(1.0);
		list.setDisable(true);
		list.setCellFactory(i -> new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				setText(item);
			}
		});
	}
	
}
