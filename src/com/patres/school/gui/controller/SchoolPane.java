package com.patres.school.gui.controller;

import com.patres.school.gui.controller.content.AbstractController;
import com.patres.school.gui.controller.content.ListTeacherController;
import com.patres.school.gui.controller.content.WelcomeController;

import lombok.Getter;

public enum SchoolPane {
	
    WELCOME("Welcome.fxml", new WelcomeController()), 
    LIST_TEACHER("ListTeacher.fxml", new ListTeacherController());

	private final static String RESOURCE_PATH = "/resources/fxml/ui/";
	@Getter private final String path;
	@Getter private final AbstractController controller;

    SchoolPane(String path, AbstractController controller) {
        this.path = RESOURCE_PATH + path;
        this.controller = controller;
    }

}
