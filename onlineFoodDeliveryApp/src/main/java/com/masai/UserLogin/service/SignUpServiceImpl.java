package com.masai.UserLogin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.UserLogin.exception.LoginException;
import com.masai.UserLogin.model.SignUp;
import com.masai.UserLogin.repository.SignUpDAO;
import com.masai.exception.CustomerException;

@Service
public class SignUpServiceImpl implements SignUpService {


	@Autowired
	private SignUpDAO signUpDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	@Override
	public SignUp createNewSignUp(SignUp newSignUp) {
		
		Optional<SignUp> opt = signUpDAO.findByUserName(newSignUp.getUserName());
		if(opt.isPresent())
		{
			throw new CustomerException("User Already Exist!");
		}
		
		return signUpDAO.save(newSignUp);
	}

	@Override
	public SignUp updateSignUpDetails(SignUp signUp, String key) {
		
		SignUp signUpDetails = getCurrentLoginUserSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LoginException("No User Found....Try To login first!");
		}
		
		signUpDAO.save(signUp);
		return signUp;
	}

}
