package com.patres.school.gui.controller.content.edit.single;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.connector.table.single.RoomConnector;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.RoomModel;
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
		String limit = textFieldMap.get("limit_people").getText();
		
		if (isNumeric(textFieldMap.get("id_room").getText())) {
			int id = Integer.parseInt(textFieldMap.get("id_room").getText());
			return new RoomModel(id, roomName, limit);
		} else {
			return new RoomModel(roomName, limit);
		}
	}

	// ================================================================================
	// Other methods
	// ================================================================================
	@Override
	protected void showDetails(AbstractModel model) {
		RoomModel room = (RoomModel) model;
		if (room != null) {
			textFieldMap.get("id_room").setText(setNotNullString(room.getId().toString()));
			textFieldMap.get("room_name").setText(setNotNullString(room.getRoomName()));
			textFieldMap.get("limit_people").setText(setNotNullString(room.getLimitPeople().toString()));
		}
	}

}
