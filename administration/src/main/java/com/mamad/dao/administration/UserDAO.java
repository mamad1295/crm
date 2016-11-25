package com.mamad.dao.administration;

import java.util.List;

import com.mamad.model.administration.User;

public interface UserDAO {
	public List<User> list();
	
	public User get(int id);
	
	public void saveOrUpdate(User collaborateur);
	
	public void delete(int id);
}