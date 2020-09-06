package com.demo.sample.service.tableDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.sample.Entity.ColumnDetails;
import com.demo.sample.dao.tableDetails.TableDetailDao;
@Service
public class TableDetailServiceImpl implements TableDetailService{
	
	@Autowired 
	private TableDetailDao  tableDetailDao;

	@Override
	public List<String> getTableNames() {
		return tableDetailDao.getTableNames();
	}

	@Override
	public List<ColumnDetails> getColumnNames(String tableName) {
		return tableDetailDao.getColumnNames(tableName);
	}

	@Override
	public String insert(String tableName, List<ColumnDetails> columnDetails) {
		return tableDetailDao.insert(tableName,columnDetails);
	}

}
