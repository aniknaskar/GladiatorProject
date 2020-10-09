package com.lti.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(scopeName = "prototype")
@Entity
@SequenceGenerator(name="seq",sequenceName = "beneficiary_seq",initialValue = 1,allocationSize = 1)
@Table(name = "BENEFICIARY_TBL")
public class BeneficiaryInfo {
	
	

	
	@Column(name = "BENEFICIARY_ACCOUNT_NUMBER",length = 20,nullable = false)
	private String beneficiaryAccountNumber;
	
	@Column(name = "BENEFICIARY_ACCOUNT_NAME",length = 50,nullable = false)
	private String beneficiaryAccountName;
	
	@Column(name = "BENEFICIARY_NICK_NAME",length = 50,nullable = true)
	private String beneficiaryNickName;
	
	@Id
	@GeneratedValue( generator = "seq" , strategy = GenerationType.SEQUENCE)
	@Column(name = "SERIAL_NUMBER",length = 10)
	private int serialNumber;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ACCOUNT_NUMBER")
	private AccountInfo accountNumber;
	
	
	


	public String getBeneficiaryAccountName() {
		return beneficiaryAccountName;
	}


	public void setBeneficiaryAccountName(String beneficiaryAccountName) {
		this.beneficiaryAccountName = beneficiaryAccountName;
	}


	public String getBeneficiaryNickName() {
		return beneficiaryNickName;
	}


	public void setBeneficiaryNickName(String beneficiaryNickName) {
		this.beneficiaryNickName = beneficiaryNickName;
	}


	public AccountInfo getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(AccountInfo accountNumber) {
		this.accountNumber = accountNumber;
	}


	@Override
	public String toString() {
		return "Beneficiary [beneficiaryAccountName=" + beneficiaryAccountName + ", beneficiaryNickName="
				+ beneficiaryNickName + "]";
	}


	public int getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}


	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	
	

}
