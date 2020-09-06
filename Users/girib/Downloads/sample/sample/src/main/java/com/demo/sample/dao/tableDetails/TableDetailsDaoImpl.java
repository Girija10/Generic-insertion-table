package com.demo.sample.dao.tableDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.sample.Entity.ColumnDetails;

@Component
public class TableDetailsDaoImpl implements TableDetailDao{

	
	public static final String PERCENTAGE_SYMBOL ="%";
	
	public static final String TEXT_FIELD ="text";
	
	public static final String OPEN_BRACKET = "(";
	
	public static final String CLOSE_BRACKET = ")";
	
	public static final String COMMA = ",";
	
	public static final  String SINGLE_QUOTES = "'";
	
	@Override
	public List<String> getTableNames() {
		List<String> tablenameList = new ArrayList<String>();
		try {
		Connection dbmdconnection = getDataBaseConnection();
		String[] types= {"TABLE"};
		ResultSet rs =dbmdconnection.getMetaData().getTables(null, null, PERCENTAGE_SYMBOL, types);
		while(rs.next()) {
			tablenameList.add(rs.getString("TABLE_NAME"));
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return tablenameList;
	}
     
	/**
	 * getDataBaseConnection method used to get database connection.
	 * @return jdbcConnection
	 * @throws SQLException
	 */
	private Connection getDataBaseConnection() throws SQLException {
		Connection jdbcConnection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		return jdbcConnection;
	}

	@Override
	public List<ColumnDetails> getColumnNames(String table) {
		List<ColumnDetails> columnameList = new ArrayList<>();
		try {
			Connection dbmdconnection = getDataBaseConnection();
		    ResultSet rs =dbmdconnection.getMetaData().getColumns(null, null, table, PERCENTAGE_SYMBOL);
		while(rs.next()) {
			setColumnDetails(columnameList, rs);
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}
		return columnameList;
	}
	
    /**
     * setColumnDetails method used to set the column details in the ColumnDetails entity
     * @param columnameList
     * @param rs
     * @throws SQLException
     */
	private void setColumnDetails(List<ColumnDetails> columnameList, ResultSet rs) throws SQLException {
		ColumnDetails columnDetails = new ColumnDetails();
		columnDetails.setColumnName(rs.getString("COLUMN_NAME"));
		String dataType =String.valueOf(JDBCType.valueOf(Integer.parseInt(rs.getString("DATA_TYPE"))));
		if(dataType.equalsIgnoreCase("INTEGER")) {
			columnDetails.setColumnType("");
		}else {
			columnDetails.setColumnType(TEXT_FIELD);
		}
		columnDetails.setColumnValue("");
		columnameList.add(columnDetails);
	}

	@Override
	public String insert(String tableName, List<ColumnDetails> columnDetails) {
				StringBuilder columnValue = new StringBuilder();
				String Query = formQueryToInsertTable(tableName, columnDetails, columnValue);
			try {
				Connection dbmdconnection = getDataBaseConnection();
				dbmdconnection.prepareStatement(Query).execute();
				dbmdconnection.commit();
				return "Success";
			} catch (SQLException e) {
				e.printStackTrace();
				return "failure";
	}
	}
    
	/**
	 * formQueryToInsertTable method used to form a query in the corresponding table
	 * @param tableName
	 * @param columnDetails
	 * @param columnValue
	 * @return
	 */
	private String formQueryToInsertTable(String tableName, List<ColumnDetails> columnDetails, StringBuilder columnValue) {
		List<String> columnNameList =columnDetails.stream().map(ColumnDetails:: getColumnName).
		collect(Collectors.toList());
		String columnNameString =String.valueOf(columnNameList)
				.replace("[", OPEN_BRACKET).replace("]", CLOSE_BRACKET);
		columnValue.append(OPEN_BRACKET);
        columnDetails.stream().forEach(action->{
		 if(action.getColumnType().equals(TEXT_FIELD)) {
			 columnValue.append(SINGLE_QUOTES).append(action.getColumnValue()).append(SINGLE_QUOTES).append(COMMA);
		 }else {
			 columnValue.append(action.getColumnValue()).append(COMMA);
		 }
         });
         columnValue.deleteCharAt(columnValue.length()-1);
         String Query = "insert into " + tableName 
			 + columnNameString +" values "+ columnValue.append(CLOSE_BRACKET);
		return Query;
	}
}
