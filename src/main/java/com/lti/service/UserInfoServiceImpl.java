package com.lti.service;

import java.util.List;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AccountInfoDao;
import com.lti.dao.CustomerInfoDao;
import com.lti.dao.UserInfoDao;
import com.lti.mail.AfterSuccessfulVerificationMail;
import com.lti.mail.NewAccountMail;
import com.lti.mail.RejectionMail;
import com.lti.model.AccountInfo;
import com.lti.model.CustomerInfo;
import com.lti.model.UserInfo;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private CustomerInfo customerInfo;

	@Autowired
	private AccountInfo accountInfo;

	@Autowired
	private AccountInfoDao accountInfoDao;

	@Autowired
	private UserInfoDao userInfoDao;

	@Autowired
	private CustomerInfoDao customerInfoDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUser(UserInfo userInfo) {

		long serviceRefNum = (long) (Math.random() * 100000000);
		String servRefNumString = Long.toString(serviceRefNum);
		userInfo.setServiceRefNumber(servRefNumString);
		userInfo.setVerifyStatus("UNVERIFIED");
		userInfoDao.createUser(userInfo);

		String message = "Dear " + userInfo.getTitle() + " " + userInfo.getFirstName() + " " + userInfo.getLastName()
				+ " your application for creating a new savings bank account has been submitted successfully.\n\n\n"
				+ "Your Service Reference Number is " + servRefNumString
				+ ".\n\n\nThank you for choosing Digiseva.\n\n\n" + "Have a Nice Day.";

		try {
			NewAccountMail.sendEmail(userInfo.getEmailId(), message);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateStatusCreateCustomer(UserInfo userInfo)
	{
		
		
		userInfoDao.updateUserStatus(userInfo);
		
		if(userInfo.getVerifyStatus().equals("VERIFIED"))
		{
					customerInfo.setAadharNumber(userInfo.getAadharNumber());
		
					Random random=new Random();
					int randomNum=(int)(random.nextDouble()*10000000);
					String customerId="2020"+randomNum;
					customerInfo.setCustomerId(customerId);
					
					
					customerInfo.setDob(userInfo.getDob());
					customerInfo.setEmailId(userInfo.getEmailId());
					customerInfo.setFatherName(userInfo.getFatherName());
					customerInfo.setFirstName(userInfo.getFirstName());
					customerInfo.setGrossAnnualIncome(userInfo.getGrossAnnualIncome());
					customerInfo.setLastName(userInfo.getLastName());
					customerInfo.setMiddleName(userInfo.getMiddleName());
					customerInfo.setMobileNumber(userInfo.getMobileNumber());
					customerInfo.setOccupationType(userInfo.getOccupationType());
					customerInfo.setPermanentAddressLine1(userInfo.getPermanentAddressLine1());
					customerInfo.setPermanentAddressLine2(userInfo.getPermanentAddressLine2());
					customerInfo.setPermanentCity(userInfo.getPermanentCity());
					customerInfo.setPermanentLandmark(userInfo.getPermanentLandmark());
					customerInfo.setPermanentPin(userInfo.getPermanentPin());
					customerInfo.setPermanentState(userInfo.getPermanentState());
					customerInfo.setResidentialAddressLine1(userInfo.getResidentialAddressLine1());
					customerInfo.setResidentialAddressLine2(userInfo.getResidentialAddressLine2());
					customerInfo.setResidentialCity(userInfo.getResidentialCity());
					customerInfo.setResidentialLandmark(userInfo.getResidentialLandmark());
					customerInfo.setResidentialPin(userInfo.getResidentialPin());
					customerInfo.setResidentialState(userInfo.getResidentialState());
					customerInfo.setSourceOfIncome(userInfo.getSourceOfIncome());
					customerInfo.setTitle(userInfo.getTitle());
					customerInfo.setPanNumber(userInfo.getPanNumber());
					
					
					
					
					accountInfo.setAccountBalance(10000);
					
					int randomAccountnum=(int)(random.nextDouble()*1000000);
					String accountNumber="6800"+randomAccountnum;
					accountInfo.setAccountNumber(accountNumber);
					
					accountInfo.setAccountType("SAVINGS");
					accountInfo.setCustomerDetails(customerInfo);
					accountInfo.setCustomerName(customerInfo.getTitle()+" "+customerInfo.getFirstName()+" "+customerInfo.getLastName());
					
					
					
					
					
					customerInfoDao.createCustomerInfo(customerInfo);
					accountInfoDao.createAccountInfo(accountInfo);
					
					
					String message="Dear "+customerInfo.getTitle()+" "+customerInfo.getFirstName()+" "+customerInfo.getLastName()+",\n"
							+"Your application for opening an account in DigiSeva has been successfully completed.\n"+
							"Your Customer ID is : "+customerId+"\nYour Savings Bank Account Number is : "+accountNumber;
					
					try
					{
						AfterSuccessfulVerificationMail.sendEmail(userInfo.getEmailId(), message);
					} 
					
					catch (MessagingException e) {
						
						e.printStackTrace();
					}
			}
		else {
			String message="Dear "+userInfo.getTitle()+" "+userInfo.getFirstName()+" "+userInfo.getLastName()+
					",\nYour application with Service reference number "+userInfo.getServiceRefNumber()+" has been rejected due to improper credentials.\nPlease apply for the new account opening again";
			try {
				RejectionMail.sendEmail(userInfo.getEmailId(), message);
			} catch (MessagingException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserInfo> getAllUnverifiedUser() {

		return userInfoDao.readAllUnVerifiedUser();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserInfo> getAllVerifiedUser() {

		return userInfoDao.readAllVerifiedUser();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<UserInfo> getAllRejectedUser() {

		return userInfoDao.readAllRejectedUser();
	}

}
