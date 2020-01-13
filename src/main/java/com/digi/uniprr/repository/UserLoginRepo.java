package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.User;


public interface UserLoginRepo extends JpaRepository<User, Integer>{
	
	User findByusername(String username);
	
	@Query("SELECT u from User u where u.email=:email AND u.isActive=1")
	User findByEmail(String email);
	
	@Modifying(clearAutomatically = true)
	@Query("update User ud set ud.password =:password where ud.username =:userName")
	void updateUserPassword(String password,String userName);

	@Query("SELECT u FROM User u WHERE u.id=:id")
	List<User> getGroupByUserId(Integer id);

	List<User> getListById(Integer id);

	@Query("SELECT u FROM User u WHERE u.email=:email AND u.password=:password")
	User getUserByEmailAndPassword(String email, String password);
	
	@Modifying(clearAutomatically = true)
	@Query("update User u set u.isActive= 0 where u.id=:id")
	void deleteUser(Integer id);

	@Query("SELECT u FROM User u WHERE u.isActive=1")
	List<User> findAllIsActiveUser();
	
}




