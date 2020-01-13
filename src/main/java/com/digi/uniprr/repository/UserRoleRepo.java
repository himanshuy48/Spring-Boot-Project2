package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Integer> {
	
	@Query("DELETE FROM UserRole ur WHERE ur.user=:userId")
	@Modifying
	void deleteUserRole(Integer userId);

}
