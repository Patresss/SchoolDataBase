package com.patres.school.gui.controller.content;

import java.util.LinkedList;

import com.patres.school.database.connector.table.RoomConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Room;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewRoomController implements Controllable {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableView<AbstractModel> roomsTable;
	@FXML
	private TableColumn<AbstractModel, String> nameTableColumn;
	@FXML
	private TableColumn<AbstractModel, Integer> limitTableColumn;

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
		RoomConnector connector = new RoomConnector();
		LinkedList<AbstractModel> roomsList = connector.select();
		ObservableList<AbstractModel> roomsObservableList = FXCollections.observableList(roomsList);

		nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("roomName"));
		limitTableColumn.setCellValueFactory(new PropertyValueFactory<>("limitPeople"));
		roomsTable.setItems(roomsObservableList);
	}
}
