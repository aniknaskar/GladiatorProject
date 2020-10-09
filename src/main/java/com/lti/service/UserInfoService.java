package com.lti.service;

import java.util.List;

import com.lti.model.UserInfo;

public interface UserInfoService {

	public void addUser(UserInfo userInfo);
	
	public void updateStatusCreateCustomer(UserInfo userInfo);
	
	public List<UserInfo> getAllUnverifiedUser();
	
	public List<UserInfo> getAllVerifiedUser();
	
	public List<UserInfo> getAllRejectedUser();
}
