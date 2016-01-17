package com.patres.school.gui.controller;

import com.patres.school.gui.controller.content.Controllable;
import com.patres.school.gui.controller.content.StatisticController;
import com.patres.school.gui.controller.content.WelcomeController;
import com.patres.school.gui.controller.content.edit.multiple.EditDutyHasStaffController;
import com.patres.school.gui.controller.content.edit.multiple.EditStaffHasSubjectController;
import com.patres.school.gui.controller.content.edit.single.EditClassController;
import com.patres.school.gui.controller.content.edit.single.EditDutyController;
import com.patres.school.gui.controller.content.edit.single.EditLaidOffStaffController;
import com.patres.school.gui.controller.content.edit.single.EditLessonController;
import com.patres.school.gui.controller.content.edit.single.EditRoomController;
import com.patres.school.gui.controller.content.edit.single.EditStaffController;
import com.patres.school.gui.controller.content.edit.single.EditSubjectController;

import lombok.Getter;

public enum SchoolPane {
	
    WELCOME("Welcome.fxml", new WelcomeController()), 
	EDIT_ROOM("EditRoom.fxml", new EditRoomController()),
	EDIT_STAFF("EditStaff.fxml", new EditStaffController()),
	EDIT_LAID_OFF_STAFF("EditLaidOffStaff.fxml", new EditLaidOffStaffController()),
	EDIT_SUBJECT("EditSubject.fxml", new EditSubjectController()),
	EDIT_CLASS("EditClass.fxml", new EditClassController()),
	EDIT_DUTY("EditDuty.fxml", new EditDutyController()),
	EDIT_LESSON("EditLesson.fxml", new EditLessonController()),
	EDIT_DUTY_HAS_STAFF("EditDutyHasStaff.fxml", new EditDutyHasStaffController()),
	EDIT_STAFF_HAS_SUBJECT("EditStaffHasSubject.fxml", new EditStaffHasSubjectController()),
	STATICTIC("Statistic.fxml", new StatisticController());
	
	private final static String RESOURCE_PATH = "/resources/fxml/ui/";
	@Getter 
	private final String path;
	@Getter 
	private final Controllable controller;

    SchoolPane(String path, Controllable controller) {
        this.path = RESOURCE_PATH + path;
        this.controller = controller;
    }

}
