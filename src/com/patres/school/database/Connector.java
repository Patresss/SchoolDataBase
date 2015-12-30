package com.patres.school.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

public class Connector {

	private static final String DATABASE_NAME = "school";
	private static final int PORT = 1001;
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:" + PORT + "/" + DATABASE_NAME;

	private static final String USER = "root";
	private static final String PASS = "pass";

	private static final Logger LOGGER = LoggerFactory.getLogger(Connector.class);
	
	@Getter
	private Statement statement;
	private Connection connection;


	public Connector() {
		try {
			Class.forName(JDBC_DRIVER);

			LOGGER.info("Connecting to a selected database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			LOGGER.info("Connected database successfully");

			LOGGER.info("Creating statement...");
			statement = connection.createStatement();
			LOGGER.info("Created statement");
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("ClassNotFoundException: {}", e);
		} 
	}
	
	public void closeConncetion() {
		LOGGER.info("Closing connection...");
		try {
			if (statement != null)
				statement.close();
		} catch (SQLException se2) {
			LOGGER.error("SQLException in statement: {}", se2);
		}
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException se) {
			LOGGER.error("SQLException in connection: {}", se);
		}
		LOGGER.info("Closed connection");
	}
}
