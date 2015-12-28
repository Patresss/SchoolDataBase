package com.patres.database.gui.controller;

import javax.annotation.PostConstruct;

import com.patres.database.Main;

import io.datafx.controller.FXMLController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.context.FXMLViewFlowContext;
import io.datafx.controller.flow.context.ViewFlowContext;
import io.datafx.controller.util.VetoException;
import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class WelcomeController {
	
	@FXMLViewFlowContext
	private ViewFlowContext context;

	@PostConstruct
	public void init() throws FlowException, VetoException {
		Main.getBundle();
		if(((Pane) context.getRegisteredObject("ContentPane")).getChildren().size() > 0)
			Platform.runLater(()-> ((Pane)((Pane) context.getRegisteredObject("ContentPane")).getChildren().get(0)).getChildren().remove(1));
	}
}
