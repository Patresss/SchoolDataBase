package com.patres.school.gui.controller.content;

import com.patres.school.database.connector.RoomConnector;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ViewRoomController extends AbstractController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private TableView<String> roomsTable;
	
	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		RoomConnector.getRooms();
	}
}
