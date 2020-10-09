package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.BeneficiaryInfo;

@Repository
public class BeneficiaryInfoDaoImpl implements BeneficiaryInfoDao {
	
	@PersistenceContext
	EntityManager entityManager=null;
	
	public BeneficiaryInfoDaoImpl() {
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void createBeneficiary(BeneficiaryInfo beneficiary) {
		entityManager.persist(beneficiary);
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public int deleteBeneficiary(String customerAccountNumber, String beneficiaryAccountNumber) {
		String jpql="Delete b from BeneficiaryInfo b where (b.beneficiaryAccountNumber=:beneficiaryAccountNumber and b.accountNumber=:customerAccountNumber) ";
		TypedQuery<BeneficiaryInfo> tQuery=entityManager.createQuery(jpql, BeneficiaryInfo.class);
		tQuery.setParameter("beneficiaryAccountNumber",beneficiaryAccountNumber);
		tQuery.setParameter("customerAccountNumber", customerAccountNumber);
		int result=tQuery.executeUpdate();
		return result;
		
		
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public List<BeneficiaryInfo> readAllBeneficiaries(String customerAccountNumber) {
		
		String jpql="Select b from BeneficiaryInfo b where  b.accountNumber.accountNumber=:customerAccountNumber";
		TypedQuery<BeneficiaryInfo> tQuery=entityManager.createQuery(jpql, BeneficiaryInfo.class);
		tQuery.setParameter("customerAccountNumber", customerAccountNumber);
		List<BeneficiaryInfo> beneficiaries=tQuery.getResultList();
		return beneficiaries;
	}

}
