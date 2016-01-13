package com.patres.school.gui.controller.content;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class WelcomeController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private Label headerLabel;
	@FXML
	private StackPane root;
	
	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		headerLabel.setAlignment(Pos.CENTER);
	}
}
