package com.cmind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="staff")
public class Staff {
	//Employee_id
	@Id
	@Column(length = 6)
	@NotEmpty(message="6桁の社員番号を入力してください")
	private String employeeId;
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	//名前
	@Column(length = 50)
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	//パスワード
	@Column(length = 255)
	@NotEmpty(message="パスワードを入力してください")
	private String password;
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
