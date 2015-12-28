package com.patres.database;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.database.gui.controller.MainController;
import com.patres.database.gui.controller.WelcomeController;
import com.patres.database.helper.PaneSetter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lombok.Getter;


public class Main extends Application {
	

	private Stage mainStage;
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	@Getter
	private static ResourceBundle bundle = ResourceBundle.getBundle("resources/language/Bundle", new Locale("pl"));

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {
		
		mainStage = stage;
		mainStage.setTitle("TITTLE");
		
		//mainStage.getIcons().add(new Image(PathKeeper.getIconPath()));
		try {
			mainStage.setScene(createScene(loadMainPane()));
		} catch (IOException e) {
			LOGGER.error("Error in start method: " + e.toString());
		}
		//setStyle();
		mainStage.setMinWidth(700);
		mainStage.setMinHeight(500);
		mainStage.show(); 
		
//		Flow flow = new Flow(MainController.class, viewConfiguration); 
//		System.out.println(flow.getViewConfiguration().getResources().getString("welcome.header"));
//		DefaultFlowContainer container = new DefaultFlowContainer();
//		flowContext = new ViewFlowContext();
//		flowContext.register("Stage", stage);
//		flow.createHandler(flowContext).start(container);
		
//		Scene scene = new Scene(new JFXDecorator(stage, container.getView()), 800, 600);
//		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
//		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());
//		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());
////		stage.initStyle(StageStyle.UNDECORATED);
////		stage.setFullScreen(true);
//		stage.setMinWidth(700);
//		stage.setMinHeight(500);
//		stage.setScene(scene);
//		stage.show();
	}
	
	private Pane loadMainPane() throws IOException {
		final FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/resources/fxml/Main.fxml"));
		loader.setResources(bundle);

		Pane mainPane = (Pane) loader.load();
		
		MainController mainController = loader.getController();
		PaneSetter.setMainController(mainController);
		
		PaneSetter paneSetter = new PaneSetter(WelcomeController.class, "/resources/fxml/ui/Welcome.fxml");
		paneSetter.loadNewStep();
		return mainPane;
	}

	private Scene createScene(final Pane mainPane) {
		Scene scene = new Scene(mainPane);
		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-fonts.css").toExternalForm());
		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-design.css").toExternalForm());
		scene.getStylesheets().add(Main.class.getResource("/resources/css/jfoenix-main-demo.css").toExternalForm());
		
		return scene;
	}
	
	
}
