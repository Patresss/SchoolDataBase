package com.patres.school.gui.helper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.Main;
import com.patres.school.gui.controller.MainController;
import com.patres.school.gui.controller.SchoolPane;
import com.patres.school.gui.controller.SideMenuController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class PaneSetter {

	private static MainController mainController;
	private static final Logger LOGGER = LoggerFactory.getLogger(PaneSetter.class);

	public PaneSetter() {
	}

	public static void setMainController(MainController mainController) {
		PaneSetter.mainController = mainController;
	}
	
	public static MainController getMainController() {
		return mainController;
	}

	public static void loadNewContent(SchoolPane controller) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(PaneSetter.class.getResource(controller.getPath()));
		loader.setResources(Main.getBundle());
		try {
			loader.setController(controller.getController());
			mainController.setPane((Node) loader.load());
		} catch (IOException e) {
			LOGGER.error("I/O Exception", e);
			System.out.println(e.getMessage());
		}
	}

	public static void loadSideMenu(String pathToFileFxml) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(PaneSetter.class.getResource(pathToFileFxml));
		loader.setResources(Main.getBundle());
		try {
			loader.setController(new SideMenuController());
			mainController.setSideMenu((Node) loader.load());
		} catch (IOException e) {
			LOGGER.error("I/O Exception", e);
		}
	}

}
