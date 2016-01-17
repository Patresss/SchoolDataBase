package com.patres.school.gui.controller.content;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.Main;
import com.patres.school.gui.dialog.ExceptionHandlerDialog;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StatisticController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private Label staffPerSubjectLabel;
	@FXML
	private Label staffPerDutyLabel;
	
	// ================================================================================
	// Properties
	// ================================================================================
	protected static final Logger LOGGER = LoggerFactory.getLogger(StatisticController.class);
	
	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		ResultSet resultSet;
		try {
			resultSet = Main.getStatement().executeQuery("select staff_per_subject()");
			resultSet.next();
			staffPerSubjectLabel.setText(resultSet.getString(1));
			
			resultSet = Main.getStatement().executeQuery("select staff_per_duty()");
			resultSet.next();
			staffPerDutyLabel.setText(resultSet.getString(1));
			
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
		}
	}
}
