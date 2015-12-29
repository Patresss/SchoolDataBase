package com.patres.school;

import java.io.IOException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfoenix.controls.JFXDecorator;
import com.patres.school.database.Connector;
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

	@Getter	private static ResourceBundle bundle = ResourceBundle.getBundle("resources/language/Bundle", new Locale("pl"));
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	private Stage mainStage;
	private Pane mainPane;
	private final static String TITTLE = "School DataBase";
	@Getter private static Statement statement;

	public static void main(String[] args) {
		statement = Connector.getStatement();
		launch(args);
	}

	public void start(Stage stage) {

		try {
			mainStage = stage;
			mainStage.setTitle(TITTLE);
			mainStage.getIcons().add(new Image("/resources/image/icon.png"));

			mainStage.setScene(createScene(loadMainPane()));

			mainStage.setMinWidth(700);
			mainStage.setMinHeight(500);
			mainStage.show();
		} catch (IOException e) {
			LOGGER.error("Error in start method - I/O Exception");
		}
	}

	private Pane loadMainPane() throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/resources/fxml/Main.fxml"));
		loader.setResources(bundle);

		mainPane = (Pane) loader.load();

		PaneSetter.setMainController(loader.getController());
		PaneSetter.loadNewContent(SchoolPane.WELCOME);
		PaneSetter.loadSideMenu("/resources/fxml/SideMenu.fxml");
		return mainPane;
	}

	private Scene createScene(final Pane mainPane) {
		Scene scene = new Scene(new JFXDecorator(mainStage, mainPane), 800, 600);
		setStyle(scene);
		return scene;
	}
	
	private void setStyle(Scene scene) {
		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());
		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());
	}

}
