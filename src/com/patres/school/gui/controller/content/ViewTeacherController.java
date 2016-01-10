package com.patres.school.gui.controller.content;

import java.util.LinkedList;

import com.jfoenix.controls.JFXListView;
import com.patres.school.database.connector.PersonnelConnector;
import com.patres.school.database.connector.TeacherConnector;
import com.patres.school.database.connector.TeachingStaffConnector;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ViewTeacherController extends AbstractController {

	// ================================================================================
	// Components
	// ================================================================================
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
		TeachingStaffConnector teachingStaff = new PersonnelConnector();
		initTeachingStaff(teachingStaff, staffSchoolVBox);
	}
	
	private void initTeacherVBox() {
		TeachingStaffConnector teachingStaff = new TeacherConnector();
		initTeachingStaff(teachingStaff, teacherVBox);
	}
	
	private void initTeachingStaff(TeachingStaffConnector teachingStaff, VBox vBox) {
		LinkedList<String> headerList = teachingStaff.getSpecificHeader();

		for (String header : headerList) {
			JFXListView<String> staffListView = new JFXListView<String>();
			LinkedList<String> staffList = teachingStaff.getSpecificStaff(header);
			if(staffList.isEmpty()) {
				continue;
			}
			
			ObservableList<String> items = FXCollections.observableArrayList(staffList);
			staffListView.setItems(items);
			staffListView.setMinWidth(500);
			staffListView.setOpacity(1.0);
			staffListView.setDisable(true);
			staffListView.getStyleClass().add("list-staf");
			
			Label subjectLabel = new Label(header + ":");
			subjectLabel.getStyleClass().add("label-staff-header");
			
			vBox.getChildren().addAll(subjectLabel, staffListView);
		}
	}
	
	
	

	
}
