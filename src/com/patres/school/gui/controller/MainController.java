package com.patres.school.gui.controller;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXRippler;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import lombok.Getter;

public class MainController {

	// ================================================================================
	// Components
	// ================================================================================
	@FXML
	private StackPane root;
	@FXML @Getter
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

	// ================================================================================
	// Configuration methods
	// ================================================================================
	public void initialize() {
		initComponents();
		sizeListener();
		//drawer.draw();
	}

	private void initComponents() {
		initDrawer();
		initTitleBurgerContainer();
	}

	// ================================================================================
	// Initialize components
	// ================================================================================

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
	// Listener
	// ================================================================================
	private void sizeListener() {
		contentScrollPane.widthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldWidth, Number newWidth) {
				content.setPrefWidth((double) newWidth);
			}
		});

		contentScrollPane.heightProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number oldHeight, Number newHeight) {
				content.setPrefHeight((double) newHeight);
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
				// content.setOpacity(0.0);
				// FadeTransition ft = new FadeTransition(Duration.millis(300),
				// content);
				// ft.setFromValue(0.0);
				// ft.setToValue(1.0);
				// ft.play();
			}
		});

	}

	public void setSideMenu(Node node) {
		sideContent.getChildren().setAll(node);
		sideContent.setAlignment(Pos.CENTER);
	}

}
