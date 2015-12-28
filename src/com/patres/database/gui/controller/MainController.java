package com.patres.database.gui.controller;

import java.io.IOException;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import com.patres.database.Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainController {

	@FXML private StackPane root;
	@FXML private StackPane content;
	@FXML private StackPane sideContent;
	
	@FXML private StackPane titleBurgerContainer;
	@FXML private JFXHamburger titleBurger;
	
	@FXML private StackPane optionsBurger;	
	@FXML private JFXRippler optionsRippler;
	
	@FXML private JFXDrawer drawer;
	@FXML private JFXPopup toolbarPopup;
	@FXML private Label exit;

	public void setPane(Node node) {
		content.getChildren().setAll(node);
		content.setAlignment(Pos.CENTER);
	}

	public void initialize() {
		
		System.out.println("diiisd");
//		
//		FXMLLoader loader2 = new FXMLLoader();
//		loader2.setLocation(MainController.class.getResource("/resources/fxml/ui/Welcome.fxml"));
//		loader2.setController(WelcomeController.class);
//		loader2.setResources(Main.getBundle());
//
//		try {
//			content = loader2.load();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		
		// create the inner flow and content

	}
}
