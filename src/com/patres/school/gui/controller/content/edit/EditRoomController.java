package com.patres.school.gui.controller.content.edit;

import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.connector.table.RoomConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Room;
import com.patres.school.gui.controller.content.Controllable;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditRoomController extends AbstractEditController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableColumn<AbstractModel, String> nameTableColumn;
	@FXML
	private TableColumn<AbstractModel, Integer> limitTableColumn;

	@FXML
	private Label nameLabel;
	@FXML
	private Label limitLabel;
	@FXML
	private JFXTextField nameTextField;
	@FXML
	private JFXTextField limitTextField;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new RoomConnector();
		initEditor();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		limitTableColumn.setCellValueFactory(new PropertyValueFactory<>("limitPeople"));
		refreshTable();
	}
	
	@Override
	protected void initLabels() {
		nameLabel.setText(Main.getBundle().getString("room.name") + ":");
		limitLabel.setText(Main.getBundle().getString("room.limit") + ":");
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getNewModel() {
		String name = nameTextField.getText();
		int limit = Integer.parseInt(limitTextField.getText());
		Room room = new Room(name, limit);
		return room;
	}
	
	@Override
	protected AbstractModel getEditModel() {
		int id = getSelectedItem().getId();
		String name = nameTextField.getText();
		int limit = Integer.parseInt(limitTextField.getText());
		Room room = new Room(id, name, limit);
		return room;
	}

	// ================================================================================
	// Listener
	// ================================================================================
	public void onlyDigitListner() {
		limitTextField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!newValue.matches("\\d*")) {
					limitTextField.setText(oldValue);
				}
			}
		});
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		Room room = (Room) model;
		if (room != null) {
			nameTextField.setText(setNotNullString(room.getRoomName()));
			limitTextField.setText(setNotNullString(room.getLimitPeople().toString()));
		}
	}

}
