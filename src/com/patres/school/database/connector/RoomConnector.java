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
	private static final String SQL_SELECT = "SELECT id, room_name, limit_people FROM public.room;";
	private static final String SQL_INSERT = "INSERT INTO room (room_name, limit_people) VALUES";
	private static final String SQL_DELETE = "DELETE FROM room WHERE id=";

	public static LinkedList<Room> getRooms() {
		LinkedList<Room> list = new LinkedList<Room>();
		ResultSet resultSet;
		try {
			resultSet = Main.getStatement().executeQuery(SQL_SELECT);

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String roomName = resultSet.getString("room_name");
				int limitPeople = resultSet.getInt("limit_people");

				list.add(new Room(id, roomName, limitPeople));
			}
			resultSet.close();
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
		return list;
	}
	
	public static void insertRoom(String name, int limit) {
		try {
			String sql = generateInsertQuery(name, limit);
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	private static String generateInsertQuery(String name, int limit) {
		return SQL_INSERT + " ('" + name + "', " +  limit +");";
	}
	
	public static void deleteRoom(int id) {
		try {
			String sql = SQL_DELETE + id;
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
	}

}
