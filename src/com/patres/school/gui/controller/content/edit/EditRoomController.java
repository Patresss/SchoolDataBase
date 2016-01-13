package com.patres.school.gui.controller.content.edit;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.RoomConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Room;
import com.patres.school.gui.controller.content.Controllable;

import javafx.fxml.FXML;
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

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new RoomConnector();
		table = DatabaseTable.ROOM;
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
	
	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String roomName = textFieldMap.get("room_name").getText();
		int limit = Integer.parseInt(textFieldMap.get("limit_people").getText());
		
		if (isNumeric(textFieldMap.get("id").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id").getText());
			return new Room(id, roomName, limit);
		} else {
			return new Room(roomName, limit);
		}
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		Room room = (Room) model;
		if (room != null) {
			textFieldMap.get("id").setText(setNotNullString(room.getId().toString()));
			textFieldMap.get("room_name").setText(setNotNullString(room.getRoomName()));
			textFieldMap.get("limit_people").setText(setNotNullString(room.getLimitPeople().toString()));
		}
	}

}
