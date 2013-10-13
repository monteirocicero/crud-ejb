package com.facade;

import javax.ejb.EJB;

import com.dao.UserDAO;
import com.model.User;

public class UserFacadeImpl implements UserFacade {
	
	@EJB
	private UserDAO userDAO;

	@Override
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}

}
