package com.nissan.service;

import java.util.List;

import com.nissan.model.Role;
import com.nissan.model.User;

public interface IUserService {
	
	//find all use4rs
	List<User> findAllUser();
	
	//find user by username and password
	public User findByUserNameAndPassword(String userName,String password);

	//find by user name
	public User findByUserName(String userName);

	//insert user
	User addUser(User user);
	
	//update user
	User updateUser(User user);
	
    //list all roles
	List<Role> findAllRoles();


	//delete
	void deleteEmployee(int userID);

	

}
