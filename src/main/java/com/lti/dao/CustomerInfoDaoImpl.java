package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.CustomerInfo;

@Repository
public class CustomerInfoDaoImpl implements CustomerInfoDao {
	
	@PersistenceContext
	EntityManager entityManager=null;
	
	public CustomerInfoDaoImpl() {
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public CustomerInfo readCustomerInfo(String customerId) {
		CustomerInfo customerDetails=entityManager.find(CustomerInfo.class, customerId);
		return customerDetails;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createCustomerInfo(CustomerInfo customerDetails) {
		entityManager.persist(customerDetails);
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateMobileNumber(String customerId, String mobileNumber) {
		CustomerInfo customerDetails=entityManager.find(CustomerInfo.class, customerId);
		customerDetails.setMobileNumber(mobileNumber);
		entityManager.merge(customerDetails);
	}

}
