package com.foodApp.UserLogin.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodApp.UserLogin.exception.LoginException;
import com.foodApp.UserLogin.model.CurrentUserSession;
import com.foodApp.UserLogin.model.LoginData;
import com.foodApp.UserLogin.model.SignUp;
import com.foodApp.UserLogin.repository.CurrentUserSessionDAO;
import com.foodApp.UserLogin.repository.SignUpDAO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private SignUpDAO signUpDAO;
	
	@Autowired
	private CurrentUserSessionDAO currentUserSessionDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	@Override
	public String logInAccount(LoginData loginData) {
		
		Optional<SignUp> opt = signUpDAO.findByUserName(loginData.getUserName());
		
		if(!opt.isPresent())
		{
			throw new LoginException("Invalid Login UserName");
		}
		
		SignUp newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionDAO.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new LoginException("User Already login with this UserId");
		}
		
		if(newSignUp.getPassword().equals(loginData.getPassword()))
		{
			String key = RandomString.getRandomNumberString();
			
			CurrentUserSession currentUserSession = new CurrentUserSession(newSignUp.getUserId(),key,LocalDateTime.now());
			currentUserSessionDAO.save(currentUserSession);
			
			return currentUserSession.toString();
			
		}
		else
			throw new LoginException("Invalid Password!");
			
		
	}

	@Override
	public String logOutFromAccount(String key) {
		
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionDAO.findByUuid(key);
		if(!currentUserOptional.isPresent())
		{
			throw new LoginException("User has not logged in with this UserId");
		}
		CurrentUserSession currentUserSession = getCurrentLoginUserSession.getCurrentUserSession(key);
		
		currentUserSessionDAO.delete(currentUserSession);
		
		return "Logged Out......";
	}

}
