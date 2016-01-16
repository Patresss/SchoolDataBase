package com.patres.school.gui.controller.content.edit.multiple;

import java.util.List;
import java.util.Map;

import com.patres.school.Main;
import com.patres.school.database.connector.table.AbstractConnector;
import com.patres.school.database.connector.table.DatabaseTable;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.gui.controller.content.edit.AbstractEditController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public abstract class AbstractEditMultipleController extends AbstractEditController {

	// ================================================================================
	// Components
	// ================================================================================
	protected List<DatabaseTable> databaseTableList;
	protected Map<String, ComboBox<AbstractModel>> comboBoxMap;

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		for (DatabaseTable table : databaseTableList) {
			String columnName = Main.getBundle().getString(table.getTableName() + ".table");
			TableColumn<AbstractModel, String> tableColumn = new TableColumn<AbstractModel, String>(columnName);
			tableColumn.setCellValueFactory(new PropertyValueFactory<>(table.getTableName()));
			modelTableView.getColumns().add(tableColumn);
		}
		refreshTable();
	}

	@Override
	protected void initEditGridPane() {
		int row = 0;
		for (DatabaseTable table : databaseTableList) {
			String columnName = Main.getBundle().getString(table.getTableName() + ".table");
			Label label = new Label(columnName + ":");
			label.getStyleClass().add("label-text-field");

			ComboBox<AbstractModel> comboBox = new ComboBox<AbstractModel>();

			AbstractConnector conectorTable = table.getConnector();
			comboBox.setItems(FXCollections.observableList(conectorTable.select()));


			editGridPane.add(label, 0, row);
			editGridPane.add(comboBox, 1, row);

			comboBox.setMinWidth(EDIT_PANE_WIDTH * 0.7);
			comboBox.setMaxWidth(EDIT_PANE_WIDTH * 0.7);
			comboBoxMap.put(table.getTableName(), comboBox);
			row++;
		}
	}


	// ================================================================================
	// FXML methods
	// ================================================================================
	@FXML
	protected void addModel() {
		connector.insert(getModel());
		refreshTable();
	}
	
	@FXML
	protected void removeModel() {
		AbstractModel model = getSelectedItem();
		connector.delete(model);
		refreshTable();
	}
	
	// ================================================================================
	// Other methods
	// ================================================================================
	protected abstract AbstractModel getModel();
	protected abstract void showDetails(AbstractModel model);

}
