package com.patres.school.gui.dialog;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DialogController {

	// ================================================================================
	// FXML variables
	// ================================================================================
	@FXML
	private Label errorLabel;
	@FXML
	private Button okButton;
	
	// ================================================================================
	// Properties
	// ================================================================================
	private ExceptionHandlerDialog exceptionHandlerDialog;
	private Exception exception;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public DialogController(ExceptionHandlerDialog exceptionHandlerDialog, Exception exception) {
		this.exceptionHandlerDialog = exceptionHandlerDialog;
		this.exception = exception;
	}
	
	public void initialize() {
		errorLabel.setText(exception.getMessage());
	}
	// ================================================================================
	// FXML methods
	// ================================================================================	
	@FXML
	public void closeDialog() {
		System.out.println("lcos");
		exceptionHandlerDialog.closeDialog();
	}
	
}
