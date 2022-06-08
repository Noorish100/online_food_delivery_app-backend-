package com.masai.UserLogin.service;

import com.masai.UserLogin.exception.LoginException;
import com.masai.UserLogin.model.CurrentUserSession;
import com.masai.UserLogin.model.SignUp;

public interface CurrentUserSessionService {
	
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException;;
	public Integer getCurrentUserSessionId(String key) throws LoginException;;
	
	public SignUp getSignUpDetails(String key) throws LoginException;;
	

}
