package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.AdminInfo;


@Repository
public class AdminInfoDaoImpl implements AdminInfoDao {

	@PersistenceContext
	EntityManager entityManager=null;
	
	public AdminInfoDaoImpl() {
		
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public AdminInfo readAdminByAdminId(String adminId) {
		AdminInfo admin=entityManager.find(AdminInfo.class,adminId);
		return admin;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createAdmin(AdminInfo adminInfo) {
		
		entityManager.persist(adminInfo);
	}

}
