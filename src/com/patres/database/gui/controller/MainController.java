package com.patres.database.gui.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private StackPane root;
	@FXML
	private StackPane content;
	@FXML
	private StackPane sideContent;

	@FXML
	private StackPane titleBurgerContainer;
	@FXML
	private JFXHamburger titleBurger;

	@FXML
	private StackPane optionsBurger;
	@FXML
	private JFXRippler optionsRippler;

	@FXML
	private JFXDrawer drawer;
	@FXML
	private JFXPopup toolbarPopup;
	@FXML
	private Label exit;

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		System.out.println("diiisd");
		initComponents();
	}
	
	private void initComponents() {
		initOptionsBurger();
		initDrawer();
		initTitleBurgerContainer();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================
	private void initOptionsBurger() {
		toolbarPopup.setPopupContainer(root);
		toolbarPopup.setSource(optionsRippler);

		optionsBurger.setOnMouseClicked((e) -> {
			toolbarPopup.show(PopupVPosition.TOP, PopupHPosition.RIGHT, -12, 15);
		});
	}

	private void initDrawer() {
		drawer.setOnDrawingAction((e) -> {
			titleBurger.getAnimation().setRate(1);
			titleBurger.getAnimation().play();
		});
		drawer.setOnHidingAction((e) -> {
			titleBurger.getAnimation().setRate(-1);
			titleBurger.getAnimation().play();
		});
	}

	private void initTitleBurgerContainer() {
		titleBurgerContainer.setOnMouseClicked((e) -> {
			if (drawer.isShown()) {
				drawer.hide();
			} else {
				drawer.draw();
			}
		});
	}

	// ================================================================================
	// Other metohds
	// ================================================================================
	public void setPane(Node node) {
		content.getChildren().setAll(node);
		content.setAlignment(Pos.CENTER);
	}

	public void setSideMenu(Node node) {
		sideContent.getChildren().setAll(node);
		sideContent.setAlignment(Pos.CENTER);
	}

}
