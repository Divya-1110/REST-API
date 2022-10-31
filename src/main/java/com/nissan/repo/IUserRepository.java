package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Role;
import com.nissan.model.User;

@Repository
public interface IUserRepository extends JpaRepositoryImplementation<User, Integer> {
	
	
	//customerRetrive username and password
	@Query("from User where userName=?1 and password=?2 and isActive=true")
	public User findByUserNameAndPassword(String userName,String password);
	
	@Query("from User where userName=?1")
	public User findByUserName(String userName);

//	@Modifying
//	@Query("update user u set u.isActive=false where u.userID=?1")
//	public void disableById(int userID);
//	
//	@Modifying
//	@Query("update user u set u.isActive=true where u.userID=?1")
//	public void enableById(int userID);


}
