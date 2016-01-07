package com.patres.school.gui.controller;

import com.patres.school.gui.controller.content.AbstractController;
import com.patres.school.gui.controller.content.AddRoomController;
import com.patres.school.gui.controller.content.EditRoomController;
import com.patres.school.gui.controller.content.ViewRoomController;
import com.patres.school.gui.controller.content.ViewTeacherController;
import com.patres.school.gui.controller.content.WelcomeController;

import lombok.Getter;

public enum SchoolPane {
	
    WELCOME("Welcome.fxml", new WelcomeController()), 
    LIST_TEACHER("ViewTeacher.fxml", new ViewTeacherController()),
	LIST_ROOM("ViewRoom.fxml", new ViewRoomController()),
	EDIT_ROOM("EditRoom.fxml", new EditRoomController()),
	ADD_ROOM("AddRoom.fxml", new AddRoomController());

	private final static String RESOURCE_PATH = "/resources/fxml/ui/";
	@Getter private final String path;
	@Getter private final AbstractController controller;

    SchoolPane(String path, AbstractController controller) {
        this.path = RESOURCE_PATH + path;
        this.controller = controller;
    }

}
