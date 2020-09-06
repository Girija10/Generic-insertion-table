package com.demo.sample.Entity;

public class ColumnDetails {
	
	private String columnName;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnValue() {
		return ColumnValue;
	}

	public void setColumnValue(String columnValue) {
		ColumnValue = columnValue;
	}

	public String getColumnType() {
		return ColumnType;
	}

	public void setColumnType(String columnType) {
		ColumnType = columnType;
	}

	private String ColumnValue;
	
	private String ColumnType;

}
