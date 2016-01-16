package com.patres.school.database.connector.table.single;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Room;

public class RoomConnector extends AbstractSingleConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public RoomConnector() {
		super(DatabaseTable.ROOM);
	}

	// ================================================================================
	// Select Model SQL
	// ================================================================================
	@Override
	protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_room");
		String roomName = resultSet.getString("room_name");
		int limitPeople = resultSet.getInt("limit_people");

		return new Room(id, roomName, limitPeople);
	}

	// ================================================================================
	// Get value from model
	// ================================================================================
	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) {
		Room room = (Room) model;
		valueList.add(getSqlForm(room.getRoomName()));
		valueList.add(getSqlForm(room.getLimitPeople()));
		return valueList;
	}

}
