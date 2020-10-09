package com.lti.dto;


public class OTP {

	private String otp;
	
	private String internetBankingId;

	public OTP() {
		super();
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OTP [otp=" + otp + "]";
	}

	public OTP(String otp) {
		super();
		this.otp = otp;
	}

	public String getInternetBankingId() {
		return internetBankingId;
	}

	public void setInternetBankingId(String internetBankingId) {
		this.internetBankingId = internetBankingId;
	}

	
	
}
