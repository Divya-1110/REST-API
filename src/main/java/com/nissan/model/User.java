package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="tblUser")


public class User {
	
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	
	@Column(nullable=false,unique=true)
	private String userName;
	
	@Column(nullable=false,unique=true)
	private String password;
	
	private String fullName;
	private boolean isActive;
	private int roleId;
	
	@JoinColumn(name="roleId",insertable=false,updatable=false)   //User.roleId=Role.roleId
	@ManyToOne
	private Role role;
	
	//default constructor
	public User() {
		super();
	}

	//parameterized constructor
	public User(int userID, String userName, String password, String fullName, boolean isActive, Role role) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.isActive = isActive;
		this.role = role;
	}

	//getters and setters
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	//@JsonBackReference           //avoid recursive
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", isActive=" + isActive + ", roleId=" + roleId + ", role=" + role + "]";
	}



	

}
