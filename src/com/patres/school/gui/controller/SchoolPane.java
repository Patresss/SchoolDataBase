package com.patres.school.gui.controller;

import com.patres.school.gui.controller.content.Controllable;
import com.patres.school.gui.controller.content.ViewRoomController;
import com.patres.school.gui.controller.content.ViewTeacherController;
import com.patres.school.gui.controller.content.WelcomeController;
import com.patres.school.gui.controller.content.edit.EditDutyController;
import com.patres.school.gui.controller.content.edit.EditRoomController;
import com.patres.school.gui.controller.content.edit.EditStaffController;
import com.patres.school.gui.controller.content.edit.EditStaffHasDutyController;
import com.patres.school.gui.controller.content.edit.EditSubjectController;

import lombok.Getter;

public enum SchoolPane {
	
    WELCOME("Welcome.fxml", new WelcomeController()), 
    LIST_TEACHER("ViewTeacher.fxml", new ViewTeacherController()),
	LIST_ROOM("ViewRoom.fxml", new ViewRoomController()),
	EDIT_ROOM("EditRoom.fxml", new EditRoomController()),
	EDIT_STAFF("EditStaff.fxml", new EditStaffController()),
	EDIT_SUBJECT("EditSubject.fxml", new EditSubjectController()),
	EDIT_DUTY("EditDuty.fxml", new EditDutyController()),
	EDIT_STAFF_HAS_DUTY("EditStaffHasDuty.fxml", new EditStaffHasDutyController());

	private final static String RESOURCE_PATH = "/resources/fxml/ui/";
	@Getter private final String path;
	@Getter private final Controllable controller;

    SchoolPane(String path, Controllable controller) {
        this.path = RESOURCE_PATH + path;
        this.controller = controller;
    }

}
