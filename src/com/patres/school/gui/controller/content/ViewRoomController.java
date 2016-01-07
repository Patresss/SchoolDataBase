package com.patres.school.gui.controller.content;

import java.util.LinkedList;

import com.patres.school.database.connector.RoomConnector;
import com.patres.school.database.table.Room;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewRoomController extends AbstractController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableView<Room> roomsTable;
	@FXML
	private TableColumn<Room, String> nameTableColumn;
	@FXML
	private TableColumn<Room, Integer> limitTableColumn;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		initRoomsTable();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	private void initRoomsTable() {
		LinkedList<Room> roomsList = RoomConnector.getRooms();
		ObservableList<Room> roomsObservableList = FXCollections.observableList(roomsList);

		nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		limitTableColumn.setCellValueFactory(new PropertyValueFactory<>("limitPeople"));
		roomsTable.setItems(roomsObservableList);
	}
}
