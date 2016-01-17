package com.patres.school.gui.dialog;

import java.io.IOException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialog.DialogTransition;
import com.patres.school.Main;
import com.patres.school.gui.helper.PaneSetter;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

public class ExceptionHandlerDialog {

	// ================================================================================
	// Properties
	// ================================================================================
	protected JFXDialog dialog;
	private Exception exception;
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerDialog.class);

	// ================================================================================
	// Constructors
	// ================================================================================
	public ExceptionHandlerDialog(Exception exception) {
		this.exception = exception;
		Pane dialogPane = PaneSetter.getMainController().getContent();
		dialog = new JFXDialog(dialogPane, getDialogContent(), DialogTransition.CENTER);
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	public void show() {
		dialog.show();
	}

	private Region getDialogContent() {
		Region content = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/resources/fxml/dialog/ExceptionHandlerDialog.fxml"));
			loader.setResources(getDialogBundle());
			loader.setController(new DialogController(this, exception));
			content = loader.load();
		} catch (IOException e) {
			LOGGER.error("I/O Exception", e);
		}
		return content;
	}

	protected ResourceBundle getDialogBundle() {
		return Main.getBundle();
	}

	public void closeDialog() {
		dialog.close();
	}

}
