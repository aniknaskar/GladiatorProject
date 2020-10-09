package com.lti.service;

import com.lti.dto.LoginDTO;
import com.lti.model.AdminInfo;

public interface AdminInfoService {

	public LoginDTO readAdminInfo(String adminId);
	public void createAdminInfo(AdminInfo adminInfo);
}
