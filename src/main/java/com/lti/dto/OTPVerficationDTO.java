package com.lti.dto;

public class OTPVerficationDTO {

	private String internetBankingId;
	private String otp;
	public OTPVerficationDTO() {
		super();
	}
	public OTPVerficationDTO(String internetBankingId, String otp) {
		super();
		this.internetBankingId = internetBankingId;
		this.otp = otp;
	}
	public String getInternetBankingId() {
		return internetBankingId;
	}
	public void setInternetBankingId(String internetBankingId) {
		this.internetBankingId = internetBankingId;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "OTPVerficationDTO [internetBankingId=" + internetBankingId + ", otp=" + otp + "]";
	}
	
	
}
