package com.patres.school.gui.controller.content.edit;

import java.util.LinkedList;

import com.jfoenix.controls.JFXButton;
import com.patres.school.database.connector.table.AbstractConnector;
import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public abstract class AbstractEditController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	protected TableView<AbstractModel> modelTableView;
	@FXML
	protected GridPane editGridPane;

	@FXML
	protected GridPane buttonGridPane;
	@FXML
	protected JFXButton addButton;
	@FXML
	protected JFXButton editButton;
	@FXML
	protected JFXButton removeButton;

	// ================================================================================
	// Properties
	// ================================================================================
	protected LinkedList<AbstractModel> modelList;
	protected ObservableList<AbstractModel> modelObservableList;
	protected AbstractConnector connector;
	protected DatabaseTable table;
	protected final int EDIT_PANE_WIDTH = 350;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	protected void initEditor() {
		initModelTable();
		initEditGridPane();
		initButons();
		initSizeGridePane();

		selectedListner();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	protected void initButons() {
		editButton.setDisable(true);
		removeButton.setDisable(true);
	}

	protected void initSizeGridePane() {
		editGridPane.setMinWidth(EDIT_PANE_WIDTH);
		int buttonSize = (EDIT_PANE_WIDTH - 20) / 3;
		addButton.setPrefWidth(buttonSize);
		editButton.setPrefWidth(buttonSize);
		removeButton.setPrefWidth(buttonSize);
		buttonGridPane.setMaxWidth(EDIT_PANE_WIDTH);
	}

	protected abstract void initEditGridPane();
	protected abstract  void initModelTable();
	protected abstract AbstractModel getModel();

	// ================================================================================
	// Listener
	// ================================================================================
	protected void selectedListner() {
		modelTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				editButton.setDisable(true);
				removeButton.setDisable(true);
			} else {
				editButton.setDisable(false);
				removeButton.setDisable(false);
				showDetails(newValue);
			}
		});
	}

	protected void onlyDigitListner(TextField textField) {
		textField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					textField.setText(oldValue);
				}
			}
		});
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	protected String setNotNullString(String text) {
		return text == null ? "" : text;
	}

	protected AbstractModel getSelectedItem() {
		return modelTableView.getSelectionModel().getSelectedItem();
	}

	protected void refreshTable() {
		modelList = connector.select();
		modelObservableList = FXCollections.observableList(modelList);
		modelTableView.setItems(modelObservableList);
	}

	protected boolean isNumeric(String str) {
		if (str.isEmpty()) {
			return false;
		}
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	protected abstract void showDetails(AbstractModel model);
}
