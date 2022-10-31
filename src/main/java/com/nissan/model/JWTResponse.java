package com.nissan.model;

public class JWTResponse { //return username,rolrid and token
	
	private final String jwttoken;
	private String userName;
	private int roleID;
	
	//parameterized constructor
	public JWTResponse(String jwttoken, String userName, int roleID) {
		super();
		this.jwttoken = jwttoken;
		this.userName = userName;
		this.roleID = roleID;
	}

	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getRoleID() {
		return roleID;
	}


	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}


	public String getJwttoken() {
		return jwttoken;
	}


	@Override
	public String toString() {
		return "JWTResponse [jwttoken=" + jwttoken + ", userName=" + userName + ", roleID=" + roleID + "]";
	}
	
	

}
