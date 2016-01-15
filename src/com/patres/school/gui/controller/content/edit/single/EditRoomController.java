package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.RoomConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Room;
import com.patres.school.gui.controller.content.Controllable;

public class EditRoomController extends AbstractEditSingle  implements Controllable {

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		connector = new RoomConnector();
		table = DatabaseTable.ROOM;
		initEditor();
		
		onlyDigitListner(textFieldMap.get("id_room"));
		onlyDigitListner(textFieldMap.get("limit_people"));
	}

	// ================================================================================
	// Get Model
	// ================================================================================
	@Override
	protected AbstractModel getModel() {
		String roomName = textFieldMap.get("room_name").getText();
		int limit = Integer.parseInt(textFieldMap.get("limit_people").getText());
		
		if (isNumeric(textFieldMap.get("id_room").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_room").getText());
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
			textFieldMap.get("id_room").setText(setNotNullString(room.getId().toString()));
			textFieldMap.get("room_name").setText(setNotNullString(room.getRoomName()));
			textFieldMap.get("limit_people").setText(setNotNullString(room.getLimitPeople().toString()));
		}
	}

}
