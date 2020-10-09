package com.lti.dto;

public class ChangeLoginPasswordDTO {

	private String internetBankingId;
	private String loginPassword;
	public ChangeLoginPasswordDTO() {
		super();
	}
	public ChangeLoginPasswordDTO(String internetBankingId, String loginPassword) {
		super();
		this.internetBankingId = internetBankingId;
		this.loginPassword = loginPassword;
	}
	public String getInternetBankingId() {
		return internetBankingId;
	}
	public void setInternetBankingId(String internetBankingId) {
		this.internetBankingId = internetBankingId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	@Override
	public String toString() {
		return "ChangeLoginPasswordDTO [internetBankingId=" + internetBankingId + ", loginPassword=" + loginPassword
				+ "]";
	}
	
	
	
	
}
