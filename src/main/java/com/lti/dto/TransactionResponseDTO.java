package com.lti.dto;

public class TransactionResponseDTO {

	private String response;

	public TransactionResponseDTO(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public TransactionResponseDTO() {
		super();
	}

	@Override
	public String toString() {
		return "TransactionResponseDTO [response=" + response + "]";
	}
	
	
}
