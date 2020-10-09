package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.UserInfo;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

	@PersistenceContext
	EntityManager entityManager=null;
	
	public UserInfoDaoImpl() {
	
		
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createUser(UserInfo userDetails)
	{
		entityManager.persist(userDetails);
		
		
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<UserInfo> readAllUnVerifiedUser() {
		String jpql="Select u from UserInfo u where u.verifyStatus=:status";
		TypedQuery<UserInfo> tQuery=entityManager.createQuery(jpql, UserInfo.class);
		tQuery.setParameter("status", "UNVERIFIED");
		List<UserInfo> userDetails=tQuery.getResultList();
		return userDetails;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<UserInfo> readAllVerifiedUser() {
		String jpql="Select u from UserInfo u where u.verifyStatus=:status";
		TypedQuery<UserInfo> tQuery=entityManager.createQuery(jpql, UserInfo.class);
		tQuery.setParameter("status", "VERIFIED");
		List<UserInfo> userDetails=tQuery.getResultList();
		return userDetails;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<UserInfo> readAllRejectedUser() {
		String jpql="Select u from UserInfo u where u.verifyStatus=:status";
		TypedQuery<UserInfo> tQuery=entityManager.createQuery(jpql, UserInfo.class);
		tQuery.setParameter("status", "REJECTED");
		List<UserInfo> userDetails=tQuery.getResultList();
		return userDetails;
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void updateUserStatus(UserInfo userInfo) {
		entityManager.merge(userInfo);
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public UserInfo getUserByServiceNumber(String serviceNumber) {
		UserInfo userInfo=entityManager.find(UserInfo.class, "95187650");
		System.out.println(userInfo);
		return userInfo;
	}

	
	
	

}
