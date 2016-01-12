package com.patres.school.gui.controller.content.edit;

import java.util.LinkedList;

import com.jfoenix.controls.JFXButton;
import com.patres.school.database.connector.table.AbstractConnector;
import com.patres.school.database.model.AbstractModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
	protected final int EDIT_PANE_WIDTH = 350;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	protected void initEditor() {
		initModelTable();
		initLabels();
		initButons();

		selectedListner();
		editGridPane.setMinWidth(EDIT_PANE_WIDTH);
		int buttonSize = (EDIT_PANE_WIDTH-20)/3;
		addButton.setPrefWidth(buttonSize);
		editButton.setPrefWidth(buttonSize);
		removeButton.setPrefWidth(buttonSize);
	}
	// ================================================================================
	// Initialize components
	// ================================================================================
	protected void initButons() {
		editButton.setDisable(true);
		removeButton.setDisable(true);
	}
	
	abstract protected void initModelTable();
	abstract protected void initLabels();
	
	// ================================================================================
	// FXML methods
	// ================================================================================
	@FXML
	private void addModel() {
		connector.insert(getNewModel());
		refreshTable();
	}
	
	@FXML
	private void editModel() {
		connector.update(getEditModel());
		refreshTable();
	}
	
	@FXML
	private void removeModel() {
		AbstractModel model = getSelectedItem();
		connector.delete(model);
		refreshTable();
	}
	
	protected abstract AbstractModel getNewModel();
	protected abstract AbstractModel getEditModel();
	
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
	
	protected abstract void showDetails(AbstractModel model);

}
