package com.patres.school.database.connector.table;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import com.patres.school.Main;
import com.patres.school.database.QueryGenerator;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.database.model.Duty;
import com.patres.school.database.model.DutyHasStaff;
import com.patres.school.database.model.Staff;
import com.patres.school.gui.dialog.ExceptionHandlerDialog;

public class DutyHasStaffConnector extends AbstractConnector {

	private static QueryGenerator queryGenerator = new QueryGenerator(DatabaseTable.DUTY_HAS_STAFF);

	// ================================================================================
	// Constructor
	// ================================================================================
	public DutyHasStaffConnector() {
		super(DatabaseTable.DUTY_HAS_STAFF);
	}

	// ================================================================================
	// SQL Query
	// ================================================================================
	@Override
	public LinkedList<AbstractModel> select() {
		String sql = queryGenerator.getSelect("view_duty_has_staff");

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
			ExceptionHandlerDialog dialog = new ExceptionHandlerDialog(e);
			dialog.show();

			LOGGER.error("SQLException: {}", e);
		}
		return list;
	}

	@Override
	public void delete(AbstractModel model) {
		try {
			DutyHasStaff dutyHasStaff = (DutyHasStaff) model;
			ArrayList<Integer> ids = new ArrayList<Integer>();
			ids.add(dutyHasStaff.getDuty().getId());
			ids.add(dutyHasStaff.getStaff().getId());
			
			String sql = queryGenerator.getDelete(ids);
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
	// SQL Query
	// ================================================================================
	@Override
	protected AbstractModel selectModel(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id_duty");
		String dutyName = resultSet.getString("duty_name");
		Integer importance = resultSet.getInt("importance");
		Duty duty = new Duty(id, dutyName, importance);

		int idStaff = resultSet.getInt("id_staff");
		String degree = resultSet.getString("degree");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		Staff staff = new Staff(idStaff, degree, firstName, lastName);

		return new DutyHasStaff(duty, staff);
	}

	@Override
	protected ArrayList<String> getValuesFromModel(AbstractModel model, ArrayList<String> valueList) throws SQLException {
		return valueList;
	}

	@Override
	protected ArrayList<String> getValues(AbstractModel model) throws SQLException {
		DutyHasStaff dhs = (DutyHasStaff) model;
		ArrayList<String> list = new ArrayList<String>();
	
		
		list.add(getSqlForm(dhs.getDuty().getId()));
		list.add(getSqlForm(dhs.getStaff().getId()));
		
		return getValuesFromModel(model, list);
	}

}
