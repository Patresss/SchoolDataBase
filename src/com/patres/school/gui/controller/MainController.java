package com.patres.school.gui.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXPopup.PopupHPosition;
import com.jfoenix.controls.JFXPopup.PopupVPosition;
import com.jfoenix.controls.JFXRippler;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class MainController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private StackPane root;
	@FXML
	private StackPane content;
	@FXML
	private ScrollPane contentScrollPane;
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
	// Other methods
	// ================================================================================
	public void setPane(Node node) {
		int durationTime = 150;
		TranslateTransition tt = new TranslateTransition(Duration.millis(durationTime), content);
		tt.setByX(contentScrollPane.getWidth());
		tt.setAutoReverse(true);
		tt.play();
		
		tt.setOnFinished(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
				content.setTranslateX(-contentScrollPane.getWidth());
				content.getChildren().setAll(node);
				content.setAlignment(Pos.CENTER);
				
				TranslateTransition tt2 = new TranslateTransition(Duration.millis(durationTime), content);
				tt2.setByX(contentScrollPane.getWidth());
				tt2.setAutoReverse(true);
				tt2.play();
//				content.setOpacity(0.0);
//				FadeTransition ft = new FadeTransition(Duration.millis(300), content);
//				ft.setFromValue(0.0);
//				ft.setToValue(1.0);
//				ft.play();
		    }
		});
		

	}

	public void setSideMenu(Node node) {
		sideContent.getChildren().setAll(node);
		sideContent.setAlignment(Pos.CENTER);
	}

}
