package com.patres.database.helper;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.database.Main;
import com.patres.database.gui.controller.MainController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class PaneSetter {

	private Class controller;
	private FXMLLoader loader;
	private String pathToFileFxml;

	private static MainController mainController;
	private static final Logger LOGGER = LoggerFactory.getLogger(PaneSetter.class);

	public PaneSetter(Class controller, String path) {
		this.controller = controller;
		this.pathToFileFxml = path;
		this.loader = new FXMLLoader();
	}

	public static void setMainController(MainController mainController) {
		PaneSetter.mainController = mainController;
	}

	public void loadNewStep() {
		loader.setLocation(PaneSetter.class.getResource(pathToFileFxml));
		loader.setResources(Main.getBundle());

		try {
			loader.setController(loadController().newInstance());
			mainController.setPane((Node) loader.load());
		} catch (InstantiationException e) {
			LOGGER.error("Instantiation Exception", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("IllegalAccess Exception", e);
		} catch (IOException e) {
			LOGGER.error("I/O Exception", e);
		}
	}

	public Class<?> loadController() {
			Class<? extends Object> c = controller;
			return c;

	}
	
}
