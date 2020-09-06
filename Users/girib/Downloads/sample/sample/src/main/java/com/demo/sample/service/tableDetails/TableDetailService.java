package com.demo.sample.service.tableDetails;

import java.util.List;

import com.demo.sample.Entity.ColumnDetails;

public interface TableDetailService {
	/**
	 * getTableName used to get the table name in the dataBase
	 * @return tableList
	 */
	List<String> getTableNames();
	/**
	 * getColumns used to get the column names in the given table
	 * @param tableName
	 * @return columndetailList
	 */
	List<ColumnDetails> getColumnNames(String tableName);
	/**
	 * insert method used to insert the element in the given table
	 * @param tableName
	 * @param columnDetails
	 * @return String (success/failure)
	 */
	String insert(String tableName, List<ColumnDetails> columnDetails);

}
