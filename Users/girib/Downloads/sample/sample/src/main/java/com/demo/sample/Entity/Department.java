package com.demo.sample.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="department")
public class Department {

	
	@Id
	@Column
	private int depId;
	
	@Column
	private String depName;

	public Department(int depId, String depName) {
		super();
		this.depId = depId;
		this.depName = depName;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}
}
