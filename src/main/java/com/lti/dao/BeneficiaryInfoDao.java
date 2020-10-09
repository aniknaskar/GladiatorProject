package com.lti.dao;

import java.util.List;

import com.lti.model.BeneficiaryInfo;

public interface BeneficiaryInfoDao {

	public void createBeneficiary(BeneficiaryInfo beneficiary);
	public int deleteBeneficiary(String customerAccountNumber,String beneficiaryAccountNumber);
	public List<BeneficiaryInfo> readAllBeneficiaries(String customerAccountNumber);
	
	
	
}
