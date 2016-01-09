package com.patres.school.database.connector.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Room;

public class RoomConnector extends AbstractConnector {

	// ================================================================================
	// Constructor
	// ================================================================================
	public RoomConnector() {
		super(Table.ROOM);
	}

	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModel(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String roomName = resultSet.getString("room_name");
		int limitPeople = resultSet.getInt("limit_people");

		return new Room(id, roomName, limitPeople);
	}

	@Override
	protected ArrayList<String> getValuesToInsert(AbstractModel model) throws SQLException {
		ArrayList<String> list = new ArrayList<String>();
		Room room = (Room) model;
		list.add(getStringForm(room.getRoomName()));
		list.add(getStringForm(room.getLimitPeople()));
		return list;
	}

}
