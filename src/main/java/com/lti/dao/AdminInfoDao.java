package com.lti.dao;

import com.lti.model.AdminInfo;

public interface AdminInfoDao {

	public AdminInfo readAdminByAdminId(String adminId);
	public void createAdmin(AdminInfo adminInfo);
}
