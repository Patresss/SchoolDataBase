package com.patres.school;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfoenix.controls.JFXDecorator;
import com.patres.school.database.connector.Connector;
import com.patres.school.gui.controller.SchoolPane;
import com.patres.school.gui.helper.PaneSetter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;

public class Main extends Application {

	@Getter
	private static ResourceBundle bundle = ResourceBundle.getBundle("resources/language/Bundle", new Locale("pl"));
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	@Getter
	private static Stage mainStage;
	
	private final static String TITTLE = "School DataBase";
	@Getter
	private static Statement statement;
	@Getter
	private static Connection connection;
	private final static int SCENE_WIDTH = 1200;
	private final static int SCENE_HEIGHT = 700;
	private static Connector connector;

	
	public static void main(String[] args) {
		launch(args);
		connector.closeConncetion();
	}

	public void start(Stage stage) {
		try {
			mainStage = stage;
			mainStage.setTitle(TITTLE);
			mainStage.getIcons().add(new Image("/resources/image/icon.png"));

			mainStage.setScene(createScene(loadMainPane()));

			mainStage.setMinWidth(700);
			mainStage.setMinHeight(500);
			connector = new Connector();
			statement = connector.getStatement();
			connection = connector.getConnection();
			mainStage.show();
			
			

		} catch (IOException e) {
			LOGGER.error("Error in start method - I/O Exception");
		}
	}

	private Pane loadMainPane() throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/resources/fxml/Main.fxml"));
		loader.setResources(bundle);

		Pane mainPane = (Pane) loader.load();
		PaneSetter.setMainController(loader.getController());
		PaneSetter.loadNewContent(SchoolPane.WELCOME);
		PaneSetter.loadSideMenu("/resources/fxml/SideMenu.fxml");
		return mainPane;
	}

	private Scene createScene(final Pane mainPane) {
		Scene scene = new Scene(new JFXDecorator(mainStage, mainPane), SCENE_WIDTH, SCENE_HEIGHT);
		setStyle(scene);
		return scene;
	}

	private void setStyle(Scene scene) {
	//	scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
		scene.getStylesheets().add(Main.class.getResource("/resources/css/style_day.css").toExternalForm());
	}


}
