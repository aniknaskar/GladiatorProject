package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.UserInfo;
import com.lti.service.UserInfoService;

@RestController
@RequestMapping(path = "user")
@CrossOrigin
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	//http://localhost:9091/Digiseva/user/createuser
	@PostMapping(path = "/createuser")
	public void createNewUser(@RequestBody UserInfo userInfo)
	{
		userInfoService.addUser(userInfo);
	}
	
	
	//http://localhost:9091/Digiseva/user/getallunverifieduser
	@GetMapping(path = "/getallunverifieduser")
	public List<UserInfo> getAllUnVerifiedUser()
	{
		return userInfoService.getAllUnverifiedUser();
	}
	
	
	//http://localhost:9091/Digiseva/user/getallverifieduser
	@GetMapping(path = "/getallverifieduser")
	public List<UserInfo> getAllVerifiedUser()
	{
		return userInfoService.getAllVerifiedUser();
	}
	
	//http://localhost:9091/Digiseva/user/getallrejecteduser
	@GetMapping(path = "/getallrejecteduser")
	public List<UserInfo> getAllRejectedUser()
	{
		return userInfoService.getAllRejectedUser();
	}
	
	//http://localhost:9091/Digiseva/user/verifyuser
	@PostMapping(path = "/verifyuser")
	public void verifyUser(@RequestBody UserInfo userInfo)
	{
		userInfoService.updateStatusCreateCustomer(userInfo);
	}
	
	
}
