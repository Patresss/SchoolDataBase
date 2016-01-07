package com.patres.school.gui.controller.content;

import java.util.LinkedList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.connector.RoomConnector;
import com.patres.school.database.table.Room;

import javafx.application.Platform;
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
	private TableView<Room> roomsTable;
	@FXML
	private TableColumn<Room, String> idTableColumn;
	@FXML
	private TableColumn<Room, String> nameTableColumn;
	@FXML
	private TableColumn<Room, Integer> limitTableColumn;

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
	// Configuration methods
	// ================================================================================
	public void initialize() {
		initRoomsTable();
		initLabels();

		roomsTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showRoomDetails(newValue));
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	private void initRoomsTable() {
		LinkedList<Room> roomsList = RoomConnector.getRooms();
		ObservableList<Room> roomsObservableList = FXCollections.observableList(roomsList);

		idTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		limitTableColumn.setCellValueFactory(new PropertyValueFactory<>("limitPeople"));
		roomsTable.setItems(roomsObservableList);
	}

	private void initLabels() {
		nameLabel.setText(Main.getBundle().getString("room.name") + ":");
		limitLabel.setText(Main.getBundle().getString("room.limit") + ":");
	}

	@FXML
	private void addRoom() {
		String name = nameTextField.getText();
		int limit = Integer.parseInt(limitTextField.getText());
		RoomConnector.insertRoom(name, limit);
	}

	@FXML
	private void editRoom() {

	}

	@FXML
	private void removeRoom() {
		refreshTable();
		Room room = getSelectedItem();
		int id = room.getId();
		RoomConnector.deleteRoom(id);
		refreshTable();
	}

	private void showRoomDetails(Room room) {
		if (room != null) {
			nameTextField.setText(setNotNullString(room.getRoomName()));
			limitTextField.setText(setNotNullString(room.getLimitPeople().toString()));

		}
	}

	private String setNotNullString(String text) {
		return text == null ? "" : text;
	}
	

	private Room getSelectedItem() {
		return roomsTable.getSelectionModel().getSelectedItem();
	}
	
	private void refreshTable() {
	    final List<Room> items = roomsTable.getItems();
	    if( items == null || items.size() == 0) return;

	    final Room item = roomsTable.getItems().get(0);
	    items.remove(0);
	    Platform.runLater(new Runnable(){
	        @Override
	        public void run() {
	            items.add(0, item);
	        }
	    });
	 }
}
