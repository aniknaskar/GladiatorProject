package com.lti.dto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class BeneficiaryDTO {

	private String customerAccountNumber;
	private String beneficiaryName;
	private String beneficiaryAccountNumber;
	private String beneficiaryConfirmAccountNumber;
	private String beneficiaryNickName;
	
	
	
	
	
	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}
	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public String getBeneficiaryConfirmAccountNumber() {
		return beneficiaryConfirmAccountNumber;
	}
	public void setBeneficiaryConfirmAccountNumber(String beneficiaryConfirmAccountNumber) {
		this.beneficiaryConfirmAccountNumber = beneficiaryConfirmAccountNumber;
	}
	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}
	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}
	public BeneficiaryDTO() {
		super();
	}
	public BeneficiaryDTO(String customerAccountNumber, String beneficiaryName, String beneficiaryAccountNumber,
			String beneficiaryConfirmAccountNumber, String beneficiaryNickName) {
		super();
		this.customerAccountNumber = customerAccountNumber;
		this.beneficiaryName = beneficiaryName;
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
		this.beneficiaryConfirmAccountNumber = beneficiaryConfirmAccountNumber;
		this.beneficiaryNickName = beneficiaryNickName;
	}
	
	
	
	
	
	
}
