package com.masai.UserLogin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.UserLogin.model.CurrentUserSession;

public interface CurrentUserSessionDAO extends JpaRepository<CurrentUserSession,Integer> {
	
	public Optional<CurrentUserSession> findByUserId(Integer userId);
	
	public Optional<CurrentUserSession> findByUuid(String uuid);

}
