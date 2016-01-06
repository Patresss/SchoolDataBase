package com.patres.school.database.connector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.Main;
import com.patres.school.database.table.Room;

public abstract class RoomConnector {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomConnector.class);
	private static final String SQL_SELECT = "SELECT room_name, limit_people FROM public.room;";

	public static LinkedList<Room> getRooms() {
		LinkedList<Room> list = new LinkedList<Room>();
		ResultSet resultSet;
		try {
			resultSet = Main.getStatement().executeQuery(SQL_SELECT);

			while (resultSet.next()) {
				String roomName = resultSet.getString("room_name");
				int limitPeople = resultSet.getInt("limit_people");

				list.add(new Room(roomName, limitPeople));
			}
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}

		return list;
	}

}
