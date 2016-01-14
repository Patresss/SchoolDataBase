package com.patres.school.gui.controller.content.edit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.connector.table.AbstractConnector;
import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
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
	protected TableColumn<AbstractModel, String> idTableColumn;

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

	@FXML
	protected ScrollPane tableScrollPane;

	// ================================================================================
	// Properties
	// ================================================================================
	protected LinkedList<AbstractModel> modelList;
	protected ObservableList<AbstractModel> modelObservableList;
	protected AbstractConnector connector;
	protected DatabaseTable table;
	protected Map<String, JFXTextField> textFieldMap;
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
		onlyDigitListner(textFieldMap.get("id"));
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	private void initButons() {
		editButton.setDisable(true);
		removeButton.setDisable(true);
	}

	private void initSizeGridePane() {
		editGridPane.setMinWidth(EDIT_PANE_WIDTH);
		int buttonSize = (EDIT_PANE_WIDTH - 20) / 3;
		addButton.setPrefWidth(buttonSize);
		editButton.setPrefWidth(buttonSize);
		removeButton.setPrefWidth(buttonSize);
		buttonGridPane.setMaxWidth(EDIT_PANE_WIDTH);
	}

	private void initEditGridPane() {
		textFieldMap = new HashMap<String, JFXTextField>();
		List<String> columnList = table.getColumn();
		columnList.get(0);

		String prefix = table.getTableName() + ".";
		int counterColumn = 0;

		for (String column : columnList) {
			String columnName = Main.getBundle().getString(prefix + column);
			Label label = new Label(columnName + ":");
			label.getStyleClass().add("label-text-field");
			JFXTextField textField = new JFXTextField();
			textFieldMap.put(column, textField);
			editGridPane.add(label, 0, counterColumn);
			editGridPane.add(textField, 1, counterColumn);
			counterColumn++;
		}
	}

	abstract protected void initModelTable();

	// ================================================================================
	// FXML methods
	// ================================================================================
	@FXML
	private void addModel() {
		if (getModel().getIdProperty() == null) {
			connector.insert(getModel(), true);
		} else {
			connector.insert(getModel(), false);
		}

		refreshTable();
	}

	@FXML
	private void editModel() {
		int id = getSelectedItem().getId();
		connector.update(getModel(), id);
		refreshTable();

	}

	@FXML
	private void removeModel() {
		AbstractModel model = getSelectedItem();
		connector.delete(model);
		refreshTable();
	}

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
		modelTableView.getSortOrder().add(idTableColumn);
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
