package com.lti.dao;



import com.lti.model.CustomerInfo;

public interface CustomerInfoDao {

	public CustomerInfo readCustomerInfo(String customerId);
	public void createCustomerInfo(CustomerInfo customerInfo);
	public void updateMobileNumber(String customerId,String mobileNumber);
	
}
