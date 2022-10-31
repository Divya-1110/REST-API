package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.Role;
import com.nissan.model.User;
import com.nissan.repo.IRoleRepository;
import com.nissan.repo.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	//field injection
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IRoleRepository roleRepo;

	@Override
	public List<User> findAllUser() {
		 return (List<User>) userRepo.findAll();
		
	}

	//find by name and password
	@Override
	public User findByUserNameAndPassword(String userName, String password) {

		User _user=userRepo.findByUserNameAndPassword(userName, password);
		//check condition
		if (userName.equals(_user.getUserName()) && password.equals(_user.getPassword())) { 
		return _user;}
		else {
			return null;
		}
	}

	//find by name
	@Override
	public User findByUserName(String userName) {
		User _user=userRepo.findByUserName(userName);

		if(userName.equals(_user.getUserName())) { 
			return _user;}
			else {
				return null;
			}
		
	}

	//add
	@Override
	public User addUser(User user) {
		
		return userRepo.save(user);
		
	}

	//update
	@Override
	public User updateUser(User user) {
		return userRepo.save(user);

	}

	@Override
	public List<Role> findAllRoles() {
		 return (List<Role>) roleRepo.findAll();
			
	}

	@Override
	public void deleteEmployee(int userID) {
		userRepo.deleteById(userID);
		
		
	}


}
