package com.patres.school.gui.controller.content;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.connector.RoomConnector;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AddRoomController extends AbstractController {

	// ================================================================================
	// Components
	// ================================================================================
	
	@FXML
	private Label nameLabel;
	@FXML
	private Label limitLabel;
	@FXML
	private JFXTextField nameTextField;
	@FXML
	private JFXTextField limitTextField;
	@FXML
	private JFXButton addButton;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		initLabels();
	}
	
	private void initLabels() {
		nameLabel.setText(Main.getBundle().getString("room.name") + ":");
		limitLabel.setText(Main.getBundle().getString("room.limit") + ":");
	}
	
	@FXML
	private void addToDatabase() {
		String name = nameTextField.getText();
		int limit = Integer.parseInt(limitTextField.getText());
		RoomConnector.insertRoom(name, limit);
	}

	

}
