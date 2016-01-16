package com.patres.school.gui.controller.content.edit.single;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfoenix.controls.JFXTextField;
import com.patres.school.Main;
import com.patres.school.database.model.AbstractModel;
import com.patres.school.gui.controller.content.edit.AbstractEditController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public abstract class AbstractEditSingle extends AbstractEditController {

	// ================================================================================
	// Properties
	// ================================================================================
	protected Map<String, JFXTextField> textFieldMap;

	// ================================================================================
	// Initialize components
	// ================================================================================
	@Override
	protected void initModelTable() {
		for (String t : table.getColumn()) {
			String columnName = Main.getBundle().getString(table.getTableName() + "." + t);
			TableColumn<AbstractModel, String> tableColumn = new TableColumn<AbstractModel, String>(columnName);
			System.out.println(getPropertyName(t));
			tableColumn.setCellValueFactory(new PropertyValueFactory<>(getPropertyName(t)));
			modelTableView.getColumns().add(tableColumn);
		}
		refreshTable();
	}

	private String getPropertyName(String text) {
		String name = new String();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '_') {
				i++;
				name += Character.toUpperCase(text.charAt(i));
			} else {
				name += text.charAt(i);
			}

			if (name.equals("id")) {
				return name;
			}
		}
		return name;
	}

	@Override
	protected void initEditGridPane() {
		textFieldMap = new HashMap<String, JFXTextField>();
		List<String> columnList = table.getColumn();

		String prefix = table.getTableName() + ".";
		int counterColumn = 0;

		for (String column : columnList) {
			String columnName = Main.getBundle().getString(prefix + column);
			Label label = new Label(columnName + ":");
			label.getStyleClass().add("label-text-field");
			JFXTextField textField = new JFXTextField();
			textFieldMap.put(column, textField);
			editGridPane.add(label, 0, counterColumn);
			editGridPane.add(textField, 1, counterColumn);
			counterColumn++;
		}
	}

	// ================================================================================
	// FXML methods
	// ================================================================================
	@FXML
	protected void addModel() {
		if (getModel().getIdProperty() == null) {
			connector.insert(getModel());
		} else {
			connector.insert(getModel());
		}

		refreshTable();
	}

	@FXML
	protected void editModel() {
		int id = getSelectedItem().getId();
		connector.update(getModel(), id);
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
	protected void refreshTable() {
		modelList = connector.select();
		modelObservableList = FXCollections.observableList(modelList);
		modelTableView.setItems(modelObservableList);
	}

	protected abstract void showDetails(AbstractModel model);
	protected abstract AbstractModel getModel();
}
