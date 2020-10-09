package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(scopeName = "prototype")
@Entity
@Table(name = "ADMIN_TBL")
public class AdminInfo {

	@Id
	@Column(name = "ADMIN_ID",length = 10,nullable = false)
	private String adminId;
	
	@Column(name = "ADMIN_PASSWORD",length = 20,nullable = false)
	private String adminPassword;
	
	
	
	public AdminInfo() {
		super();
	}



	public AdminInfo(String adminId, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
	}



	public String getAdminId() {
		return adminId;
	}



	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}



	public String getAdminPassword() {
		return adminPassword;
	}



	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + "]";
	}
	
	
	
	
}
