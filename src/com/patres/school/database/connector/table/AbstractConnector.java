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

public abstract class AbstractConnector {
	
	// ================================================================================
	// Properties
	// ================================================================================
	private QueryGenerator queryGenerator;
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEditController.class);
	private static Statement statement = Main.getStatement();
	
	// ================================================================================
	// Constructor
	// ================================================================================
	public AbstractConnector(Table table) {
		this.queryGenerator = new QueryGenerator(table);
	}
	
	// ================================================================================
	// SQL Query
	// ================================================================================
	public LinkedList<AbstractModel> select() {
		String sql = queryGenerator.getSelect();
		
		LinkedList<AbstractModel> list = new LinkedList<AbstractModel>();
		ResultSet resultSet;
		try {
			LOGGER.info("Executing query... : {}", sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				AbstractModel model = selectModel(resultSet);
				list.add(model);
			}
			resultSet.close();
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
		return list;
	}
	
	public void insert(AbstractModel model) {
		try {
			String sql = queryGenerator.getInsert(getValuesToInsert(model));
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	public void delete(AbstractModel model) {
		try {
			String sql = queryGenerator.getDelete(model.getId());
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	public void update(AbstractModel model) {
		try {
			String sql = queryGenerator.getUpdate(getValuesToInsert(model), model.getId());
			LOGGER.info("Executing query... : {}", sql);
			Main.getStatement().executeUpdate(sql);
			LOGGER.info("Executed query: {}", sql);
		} catch (SQLException e) {
			LOGGER.error("SQLException: {}", e);
		}
	}
	
	// ================================================================================
	// Abstract sql
	// ================================================================================
	abstract protected AbstractModel selectModel(ResultSet resultSet) throws SQLException;
	abstract protected ArrayList<String> getValuesToInsert(AbstractModel model) throws SQLException;


	// ================================================================================
	// Other methods
	// ================================================================================
	protected String getStringForm(Object o) {
		if(o instanceof String) {
			return "'" + o.toString() + "'";
		} else {
			return o.toString();
		}
	}

}
