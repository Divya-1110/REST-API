package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Role;
import com.nissan.model.User;
import com.nissan.service.IUserService;
import com.nissan.service.LoginService;

@CrossOrigin                   //helps to avoid (cors) error
@RestController
@RequestMapping("api/")
public class UserController {

	//field DI Injection
	@Autowired
	IUserService userService;
	
	@Autowired
	LoginService userDetailsService;
	
	//List all users
	@GetMapping("users")
	public List<User> findAllUsers(){
		return userService.findAllUser();
	}
	//List all users
		@GetMapping("roles")
		public List<Role> findAllRoles(){
			return userService.findAllRoles();
		}
	//get user  by username and password
	@GetMapping("user-login/{userName}&{password}")
	public User findUserByNameAndPassword(@PathVariable String userName,@PathVariable String password) {
		return userService.findByUserNameAndPassword(userName, password);
	}
		//get by user name
		@GetMapping("users/{userName}")
		public User findUserByName(@PathVariable String userName) {
			return userService.findByUserName(userName);
		}
		//add user
		@PostMapping("users")
			public ResponseEntity<User> addUser(@RequestBody User user){
				System.out.println("Inserting a record");
				return new ResponseEntity<User> (userDetailsService.save(user),HttpStatus.OK);
			}
		
		//update user
		@PutMapping("users")
		public User updateUser(@RequestBody User user) {
			System.out.println("Updating a record");
			userService.updateUser(user);
			return user;
		}
		
		//delete user
		@DeleteMapping("users/{userID}")
		public void deleteEmployee(@PathVariable int userID) {
			userService.deleteEmployee(userID);
			}
		
		
		
}
