package com.patres.school.gui.controller.content;

import java.util.LinkedList;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.connector.table.RoomConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Room;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditRoomController extends AbstractController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableView<AbstractModel> roomsTable;
	@FXML
	private TableColumn<AbstractModel, String> idTableColumn;
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
	@FXML
	private JFXButton addButton;
	@FXML
	private JFXButton editButton;
	@FXML
	private JFXButton removeButton;

	// ================================================================================
	// Properties
	// ================================================================================
	private LinkedList<AbstractModel> roomsList;
	private ObservableList<AbstractModel> roomsObservableList;
	RoomConnector connector;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		initRoomsTable();
		initLabels();
		initButons();

		selectedListner();
		onlyDigitListner();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	private void initRoomsTable() {
		connector = new RoomConnector();
		
		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		limitTableColumn.setCellValueFactory(new PropertyValueFactory<>("limitPeople"));
		refreshTable();
	}

	private void initLabels() {
		nameLabel.setText(Main.getBundle().getString("room.name") + ":");
		limitLabel.setText(Main.getBundle().getString("room.limit") + ":");
	}
	
	private void initButons() {
		editButton.setVisible(false);
		removeButton.setVisible(false);
	}


	// ================================================================================
	// FXML methods
	// ================================================================================
	@FXML
	private void addRoom() {
		String name = nameTextField.getText();
		int limit = Integer.parseInt(limitTextField.getText());
		Room room = new Room(name, limit);
		connector.insert(room);

		refreshTable();
	}

	@FXML
	private void editRoom() {
		int id = getSelectedItem().getId();
		String name = nameTextField.getText();
		int limit = Integer.parseInt(limitTextField.getText());
		Room room = new Room(id, name, limit);
		connector.update(room);

		refreshTable();
	}

	@FXML
	private void removeRoom() {
		AbstractModel model = getSelectedItem();
		connector.delete(model);

		refreshTable();
	}

	// ================================================================================
	// Listener
	// ================================================================================
	private void selectedListner() {
		roomsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
		if(newValue==null) {
			editButton.setVisible(false);
			removeButton.setVisible(false);
		} else {
			editButton.setVisible(true);
			removeButton.setVisible(true);
			showRoomDetails(newValue);
		}
			
		});
	}
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
	private void showRoomDetails(AbstractModel model) {
		Room room = (Room) model;
		if (room != null) {
			nameTextField.setText(setNotNullString(room.getRoomName()));
			limitTextField.setText(setNotNullString(room.getLimitPeople().toString()));
		}
	}

	private String setNotNullString(String text) {
		return text == null ? "" : text;
	}

	private AbstractModel getSelectedItem() {
		return roomsTable.getSelectionModel().getSelectedItem();
	}

	private void refreshTable() {
		roomsList = connector.select();
		roomsObservableList = FXCollections.observableList(roomsList);
		roomsTable.setItems(roomsObservableList);
		roomsTable.getSortOrder().add(idTableColumn);
	}


}
