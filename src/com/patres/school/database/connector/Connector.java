package com.patres.school.database.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.gui.dialog.ExceptionHandlerDialog;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import lombok.Getter;

public class Connector {

	private static final String DATABASE_NAME = "ccswpwjw";
	private static final int PORT = 5432;
	private static final String HOST = "jumbo.db.elephantsql.com";
	private static final String USER = "ccswpwjw";
	private static final String PASS = "pass";
	private static final String SCHEMA = "School";
	
	private static final String DB_URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;

	private static final String JDBC_DRIVER = "org.postgresql.Driver";
	private static final Logger LOGGER = LoggerFactory.getLogger(Connector.class);
	
	@Getter
	private Statement statement;
	@Getter
	private Connection connection;


	public Connector() {
		try {
			Class.forName(JDBC_DRIVER);

			LOGGER.info("Connecting to a selected database...");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			LOGGER.info("Connected database successfully");

			LOGGER.info("Creating statement...");
			statement = connection.createStatement();
			statement.execute("SET SCHEMA '"+ SCHEMA + "'");
			LOGGER.info("Created statement");
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("B³¹d");
			alert.setHeaderText("B³¹d z po³¹czeniem bazy.");
			alert.setContentText(e.getMessage());

			alert.showAndWait();
			
			LOGGER.error("SQLException: {}", e);
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
		} catch (ClassNotFoundException e) {
			LOGGER.error("ClassNotFoundException: {}", e);
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
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
		} catch (SQLException e) {
			LOGGER.error("SQLException in connection: {}", e);
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
		}
		LOGGER.info("Closed connection");
	}
}
