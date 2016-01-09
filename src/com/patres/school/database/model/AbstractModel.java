package com.patres.school.database.model;

import javafx.beans.property.SimpleIntegerProperty;

public class AbstractModel {

	// ================================================================================
	// Properties
	// ================================================================================
	private SimpleIntegerProperty id;
	
	// ================================================================================
	// Constructors
	// ================================================================================
	public AbstractModel(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	
	public AbstractModel() {
	}
	
	// ================================================================================
	// Accessors
	// ================================================================================
	public Integer getId() {
        return id.get();
    }
	
    public void setId(Integer idRoom) {
    	id.set(idRoom);
    }
}
