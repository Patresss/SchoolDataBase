package com.patres.database.helper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.database.Main;
import com.patres.database.gui.controller.MainController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class PaneSetter {

	private static MainController mainController;
	private static final Logger LOGGER = LoggerFactory.getLogger(PaneSetter.class);

	public PaneSetter() {}

	public static void setMainController(MainController mainController) {
		PaneSetter.mainController = mainController;
	}

	public static void loadNewContent(String pathToFileFxml) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(PaneSetter.class.getResource(pathToFileFxml));
		loader.setResources(Main.getBundle());

		try {
			mainController.setPane((Node) loader.load());
		}catch (IOException e) {
			LOGGER.error("I/O Exception", e);
		}
	}
	
	public static void loadSideMenu(String pathToFileFxml) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(PaneSetter.class.getResource(pathToFileFxml));
		loader.setResources(Main.getBundle());
		try {
			mainController.setSideMenu((Node) loader.load());
		}catch (IOException e) {
			LOGGER.error("I/O Exception", e);
		}
	}


	
}
