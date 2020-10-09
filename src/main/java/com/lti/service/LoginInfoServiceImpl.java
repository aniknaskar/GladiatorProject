package com.lti.service;

import java.util.Date;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.AccountInfoDao;
import com.lti.dao.LoginInfoDao;
import com.lti.dto.ChangeLoginPasswordDTO;
import com.lti.dto.InternetBankingRegistrationDTO;
import com.lti.dto.LoginDTO;
import com.lti.dto.OTP;
import com.lti.dto.OTPVerficationDTO;
import com.lti.mail.ForgotInternetBankingIdMail;
import com.lti.mail.ForgotLoginPasswordMail;
import com.lti.mail.LoginAccountActivationThroughOTPMail;
import com.lti.mail.SendInternetBankingIdMail;
import com.lti.model.AccountInfo;
import com.lti.model.LoginInfo;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

	@Autowired
	private LoginDTO loginDTO;

	@Autowired
	private AccountInfoDao accountInfoDao;

	@Autowired
	private AccountInfo accountInfo;

	@Autowired
	private LoginInfo loginInfo;

	@Autowired
	private LoginInfoDao loginInfoDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public LoginDTO getLoginInfo(String internetBankingId) {

		loginInfo = loginInfoDao.readLoginInfo(internetBankingId);

		if (loginInfo == null) {
			loginDTO.setInternetBankingId("NULL");
			loginDTO.setLoginPassword("NULL");
			loginDTO.setAccountNumber("NULL");
			loginDTO.setCustomerName("NULL");
			loginDTO.setAccountBalance("NULL");
			loginDTO.setTransactionPassword("NULL");

			return loginDTO;
		}

		if (loginInfo.isLocked()) {
			loginDTO.setInternetBankingId("LOCKED");
			loginDTO.setLoginPassword("LOCKED");
			loginDTO.setAccountNumber("LOCKED");
			loginDTO.setCustomerName("LOCKED");
			loginDTO.setAccountBalance("LOCKED");
			loginDTO.setTransactionPassword("LOCKED");

			return loginDTO;
		}

		loginInfo.setLastLogin(new Date());

		loginInfoDao.updateLogininfo(loginInfo);

		loginDTO.setInternetBankingId(loginInfo.getInternetBankingId());
		loginDTO.setLoginPassword(loginInfo.getLoginPassword());
		loginDTO.setAccountNumber(loginInfo.getAccountInfo().getAccountNumber());
		loginDTO.setCustomerName(loginInfo.getAccountInfo().getCustomerName());
		loginDTO.setAccountBalance("" + loginInfo.getAccountInfo().getAccountBalance());
		loginDTO.setTransactionPassword(loginInfo.getAccountInfo().getTransactionPassword());
		loginDTO.setNumberOfAttemptedLogin(loginInfo.getNumberOfAttemptedLogin());

		return loginDTO;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public OTP addLoginInfo(InternetBankingRegistrationDTO internetBankingRegistrationDTO) {

		OTP Otpval = new OTP();
		int otp = 0;
		accountInfo = accountInfoDao.readAccountInfo(internetBankingRegistrationDTO.getAccountNumber());

		try {
			if (accountInfo == null) {
				Otpval.setOtp("ACCOUNT NUMBER DOESN'T EXIST");
			}

			else if (accountInfo.getLoginInfo() != null) {

				Otpval.setOtp("ALREADY REGISTERED");

			}

			else {

				accountInfo.setTransactionPassword(internetBankingRegistrationDTO.getTransactionPassword());

				loginInfo.setAccountInfo(accountInfo);
				loginInfo.setEmailId(accountInfo.getCustomerDetails().getEmailId());

				Random random = new Random();
				int randomNum = (int) (random.nextDouble() * 100000000);
				String internetBankingId = "68" + randomNum;
				loginInfo.setInternetBankingId(internetBankingId);

				loginInfo.setLastLogin(null);
				loginInfo.setLocked(true);
				loginInfo.setLoginPassword(internetBankingRegistrationDTO.getLoginPassword());
				loginInfo.setMobileNumber(accountInfo.getCustomerDetails().getMobileNumber());
				loginInfo.setNumberOfAttemptedLogin(0);

				accountInfo.setLoginInfo(loginInfo);

				loginInfoDao.createInternetBanking(loginInfo);
				accountInfoDao.updateAccountInfo(accountInfo);

				otp = (int) (Math.random() * 10000);
				String otpMessage = "Dear " + accountInfo.getCustomerName()
						+ ",\nYour new Internet Banking ID has been created.\n\nInternet Banking ID: "
						+ internetBankingId + ".\n\nYour OTP for verification :" + otp;

				LoginAccountActivationThroughOTPMail.sendEmail(accountInfo.getCustomerDetails().getEmailId(),
						otpMessage);

				Otpval.setOtp(otp + "");
				Otpval.setInternetBankingId(internetBankingId);
			}
		}

		catch (MessagingException e) {

			e.printStackTrace();
		} catch (NullPointerException e) {
			Otpval.setOtp("ALREADY REGISTERED");
		}

		return Otpval;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void unlockLoginInfo(String internetBankingId) {
		LoginInfo loginInfo = loginInfoDao.readLoginInfo(internetBankingId);
		loginInfo.setLocked(false);
		loginInfoDao.updateLogininfo(loginInfo);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateLoginPassword(ChangeLoginPasswordDTO changeLoginPasswordDTO) {
		loginInfo = loginInfoDao.readLoginInfo(changeLoginPasswordDTO.getInternetBankingId());
		loginInfo.setLoginPassword(changeLoginPasswordDTO.getLoginPassword());
		loginInfo.setLocked(false);
		loginInfoDao.updateLogininfo(loginInfo);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String forgotLoginPassword(String internetBankingId) {
		LoginInfo loginInfo = loginInfoDao.readLoginInfo(internetBankingId);
		int randomotp = (int) (Math.random() * 10000);
		String otp = "" + randomotp;
		String message = "Dear " + loginInfo.getAccountInfo().getCustomerName()
				+ " ,\nYour OTP for setting a new Login password is " + otp + "\n\nHave a nice day!!";

		try {
			ForgotLoginPasswordMail.sendEmail(loginInfo.getEmailId(), message);
		}

		catch (MessagingException e) {

			e.printStackTrace();
		}

		return otp;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String forgotInternetBankingId(String accountNumber) {
		accountInfo = accountInfoDao.readAccountInfo(accountNumber);
		int randomotp = (int) (Math.random() * 10000);
		String otp = "" + randomotp;
		String message = "Dear " + accountInfo.getCustomerName()
				+ " ,\nYour OTP for retrieving your Internet Banking ID is " + otp + "\n\nHave a nice day!!";

		try {

			ForgotInternetBankingIdMail.sendEmail(accountInfo.getCustomerDetails().getEmailId(), message);
		} catch (MessagingException e) {

			e.printStackTrace();
		}
		return otp;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void sendInternetBankingId(String accountNumber) {
		accountInfo = accountInfoDao.readAccountInfo(accountNumber);
		String message = "Dear " + accountInfo.getCustomerName() + ",\n"
				+ "Your Otp Verification was successful.\nYour Internet Banking Id is: "
				+ accountInfo.getLoginInfo().getInternetBankingId() + "\nHave a nice day!";

		try {
			SendInternetBankingIdMail.sendEmail(accountInfo.getCustomerDetails().getEmailId(), message);
		} catch (MessagingException e) {

			e.printStackTrace();
		}

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void lockAccount(String accountNumber) {
		LoginInfo loginInfo = loginInfoDao.readLoginInfo(accountNumber);
		loginInfo.setLocked(true);
		loginInfo.setNumberOfAttemptedLogin(0);
		loginInfoDao.updateLogininfo(loginInfo);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addNumberOfAttemptedLogin(String accountNumber) {
		LoginInfo loginInfo = loginInfoDao.readLoginInfo(accountNumber);
		loginInfo.setNumberOfAttemptedLogin(loginInfo.getNumberOfAttemptedLogin() + 1);
		loginInfoDao.updateLogininfo(loginInfo);
	}

}
