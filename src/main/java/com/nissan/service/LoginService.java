package com.nissan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nissan.model.User;
import com.nissan.repo.IUserRepository;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//custom method
		User user=userRepo.findByUserName(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("user not found with username:"+username);
		}
		
		System.out.println(user.getPassword());
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(),
				user.getPassword(),new ArrayList<>());
	}
	
	//save
	public User save(User user) {
		User newUser=new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRoleId(user.getRoleId());
		newUser.setFullName(user.getFullName());
		newUser.setActive(user.isActive());
		
		return userRepo.save(newUser);
		
		
	}
	
	//search by username
	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);	
		}

}
