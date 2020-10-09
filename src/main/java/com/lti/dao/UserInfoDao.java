package com.lti.dao;


import java.util.List;

import com.lti.model.UserInfo;



public interface UserInfoDao {

	public void createUser(UserInfo userDetails);
	public List<UserInfo> readAllUnVerifiedUser();
	public List<UserInfo> readAllVerifiedUser();
	public List<UserInfo> readAllRejectedUser();
	public void updateUserStatus(UserInfo userInfo);
	public UserInfo getUserByServiceNumber(String serviceNumber);
	
}
