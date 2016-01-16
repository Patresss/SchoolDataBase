package com.patres.school.database.connector.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.patres.school.Main;
import com.patres.school.database.QueryGenerator;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.gui.controller.content.edit.AbstractEditController;
import com.patres.school.gui.dialog.ExceptionHandlerDialog;

public abstract class AbstractConnector {
	
	// ================================================================================
	// Properties
	// ================================================================================
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractEditController.class);
	protected static Statement statement = Main.getStatement();
	protected QueryGenerator queryGenerator;
	
	// ================================================================================
	// Constructor
	// ================================================================================
	public AbstractConnector(DatabaseTable table) {
		this.queryGenerator = new QueryGenerator(table);
	}
	
	// ================================================================================
	// Select
	// ================================================================================
	public LinkedList<AbstractModel> select() {
		String sql = getSelectSql();
		
		LinkedList<AbstractModel> list = new LinkedList<AbstractModel>();
		ResultSet resultSet;
		try {
			LOGGER.info("Executing query... : {}", sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				AbstractModel model = selectModelSql(resultSet);
				list.add(model);
			}
			resultSet.close();
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
		}
		return list;
	}
	
	protected abstract String getSelectSql();
	
	// ================================================================================
	// Insert
	// ================================================================================
	public void insert(AbstractModel model) {
		try {
			String sql = queryGenerator.getInsert(getValues(model));
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
			
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	// ================================================================================
	// Delete
	// ================================================================================
	public void delete(AbstractModel model) {
		try {
			String sql = queryGenerator.getDelete(model.getId());
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
			
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	// ================================================================================
	// Update
	// ================================================================================
	public void update(AbstractModel model, int id) {
		try {
			String sql = queryGenerator.getUpdate(getValues(model), id);
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
			
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	public void update(AbstractModel model, ArrayList<Integer> ids) {
		try {
			String sql = queryGenerator.getUpdate(getValues(model), ids);
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();
			
			LOGGER.error("SQLException: {}", e);
		}
	}

	

	
	
	
	// ================================================================================
	// Abstract sql
	// ================================================================================
	protected abstract ArrayList<String> getValues(AbstractModel model);
	
	abstract protected AbstractModel selectModelSql(ResultSet resultSet) throws SQLException;


	// ================================================================================
	// Other methods
	// ================================================================================
	protected String getSqlForm(Object o) {
		if(o instanceof String) {
			if(((String) o).isEmpty()) {
				return "null";
			} else {
				return "'" + o.toString() + "'";
			}
			
		} else {
			return o.toString();
		}
	}

}
