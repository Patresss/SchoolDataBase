package com.patres.school.gui.controller;

import java.util.LinkedList;

import com.jfoenix.controls.JFXListView;
import com.patres.school.database.ListStaff;
import com.patres.school.hellper.MapStaffDuty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.VBox;

public class ListTeacherController extends AbstractController {

	@FXML
	private VBox contentVBox;
	
	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {

		ListStaff listStaff = new ListStaff();
		LinkedList<MapStaffDuty> listWithoutTeacher = listStaff.getStaffWithoutTeacher();

		for (MapStaffDuty m : listWithoutTeacher) {
			JFXListView<String> list = new JFXListView<String>();
			ObservableList<String> items = FXCollections.observableArrayList(m.getPerson());
			list.setItems(items);
			list.setMinWidth(500);
			list.setOpacity(1.0);
			changeItem(list);
			list.setDisable(true);
			Label dutyLabel = new Label(m.getDuty() + ":");
			
			dutyLabel.getStyleClass().add("label-duty");
			contentVBox.getChildren().addAll(dutyLabel, list);
		}
	}
	
	private void changeItem(JFXListView<String> list) {
		list.setCellFactory(i -> new ListCell<String>() {
			@Override
			protected void updateItem(String item, boolean empty) {
				super.updateItem(item, empty);
				setText(item);
			}

		});
	}
}
