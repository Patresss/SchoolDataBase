package com.patres.school.database;

import java.util.ArrayList;

import com.patres.school.database.connector.table.DatabaseTable;

public class QueryGenerator {
	
	private DatabaseTable table;

	public QueryGenerator(DatabaseTable table){
		this.table = table;
	}
	
	public String getSelect() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
			sql.append(String.join(", ", table.getColumn()));
		sql.append(" FROM ");
			sql.append(table.getTableName());	
		return sql.toString();
	}
	
	public String getSelect(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
			sql.append(String.join(", ", table.getColumn()));
		sql.append(" FROM ");
			sql.append(table.getTableName());	
		sql.append(" WHERE ");
			sql.append("id=");
			sql.append(id);
		return sql.toString();
	}
	
	public String getSelect(String view) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *");
		sql.append(" FROM ");
			sql.append(view);	
		return sql.toString();
	}
	
	public String getInsert(ArrayList<String> valuesToInsert, boolean withNewId) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
			sql.append(table.getTableName());
			sql.append(" (");
			if(withNewId) {
			sql.append(String.join(", ", table.getColumnWithoutId()));
			} else {
				sql.append(String.join(", ", table.getColumn()));
			}
			sql.append(") ");
		sql.append("VALUES ");
			sql.append(" (");
			sql.append(String.join(", ", valuesToInsert));
			sql.append(") ");	
		return sql.toString();
	}
	
	public String getDelete(int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
			sql.append(table.getTableName());
		sql.append(" WHERE ");
			sql.append("id_");
			sql.append(table.getTableName());
			sql.append("=");
			sql.append(id);
		return sql.toString();
	}
	
	public String getDelete(int id1,int id2) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
			sql.append(table.getTableName());
		sql.append(" WHERE ");
			sql.append(getWhereString(id1, id2));
		return sql.toString();
	}
    
	public String getUpdate(ArrayList<String> valuesToUpdate, int id) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
			sql.append(table.getTableName());
		sql.append(" SET ");
			sql.append(String.join(", ", getUpdateMap(valuesToUpdate)));
		sql.append(" WHERE ");
			sql.append("id_");
			sql.append(table.getTableName());
			sql.append("=");
			sql.append(id);
		return sql.toString();
	}
    
	private ArrayList<String> getUpdateMap(ArrayList<String> valuesToUpdate) {
		if(valuesToUpdate.size() != table.getColumn().size()) {
			 throw new RuntimeException("Size of values to update isn'r equals column size");
		}
		
		ArrayList<String> updateMap = new ArrayList<String>();
		for(int i=0; i<valuesToUpdate.size(); i++) {
			String column = table.getColumn().get(i);
			String value = valuesToUpdate.get(i);
			updateMap.add(column + "=" + value);
		}
		return updateMap;
	}
	
	private String getWhereString(int id1, int id2) {
		StringBuilder sql = new StringBuilder();
		sql.append(table.getColumn().get(0));
		sql.append("=");
		sql.append(id1);
		sql.append(" AND ");
		sql.append(table.getColumn().get(1));
		sql.append("=");
		sql.append(id2);
		return sql.toString();
	}
}
