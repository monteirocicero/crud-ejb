package com.facade;

import javax.ejb.Local;

import com.model.User;

@Local
public interface UserFacade {
	User findUserByEmail(String email);
}
