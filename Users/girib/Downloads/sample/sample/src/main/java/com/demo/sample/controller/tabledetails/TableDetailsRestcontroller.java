package com.demo.sample.controller.tabledetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sample.Entity.ColumnDetails;
import com.demo.sample.service.tableDetails.TableDetailService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TableDetailsRestcontroller {
	
	@Autowired 
	private TableDetailService  tableDetailService;
	
	
	public TableDetailsRestcontroller(TableDetailService tableDetailService) {
		super();
		this.tableDetailService=tableDetailService;
	}
	
	/**
	 * getTableName used to get the table name in the dataBase
	 * @return tableList
	 */
	@GetMapping("/tables")
	public List<String> getTableName(){
		return tableDetailService.getTableNames();
	}
	
	/**
	 * getColumns used to get the column names in the given table
	 * @param tableName
	 * @return columndetailList
	 */
	@GetMapping("/getColumns/{tableName}")
	public List<ColumnDetails> getColumns(@PathVariable String tableName){
		return tableDetailService.getColumnNames(tableName);
	}
	
	
	/**
	 * insert method used to insert the element in the given table
	 * @param tableName
	 * @param columnDetails
	 * @return String (success/failure)
	 */
	@PostMapping("/insert/{tableName}")
	public  String insert(@PathVariable String tableName,
			@RequestBody List<ColumnDetails> columnDetails){
		return tableDetailService.insert(tableName,columnDetails);
		  
	}

}
