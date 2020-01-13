package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email=:email")
	List<User> getByEmail(String email);

	User findByEmail(String email);

	@Modifying(clearAutomatically = true)
	@Query("update User ud set ud.password =:password where ud.token =:token")
	void updateUserPassword(String password, String token);

	@Query("SELECT u FROM User u WHERE u.id=:user_id")
	List<User> getGroupByUserId(Integer user_id);

	@Modifying(clearAutomatically = true)
	@Query("update User ud set ud.token =:token where ud.email =:userEmail")
	void updateTokenByUser(String userEmail, String token);

	@Query("SELECT u FROM User u WHERE u.token=:token")
	List<User> findUserDetailsByToken(String token);

	@Modifying(clearAutomatically = true)
	@Query("update User ud set ud.password =:password where ud.token =:token")
	void updatePasswordByToken(String password, String token);

	@Modifying(clearAutomatically = true)
	@Query("update User ud set ud.token =:blank where ud.token =:token")
	void deleteTokenByUser(String token, String blank);

	@Query(value = "SELECT * FROM users WHERE id IN (SELECT usr_id FROM user_role where role_id in (:roleId))", nativeQuery = true)
	List<User> getUserListByRoleId(List<Integer> roleId);

	@Query(value = "SELECT * from users u LEFT JOIN user_role ur ON ur.usr_id=u.id LEFT JOIN users_journals uj ON uj.user_id= u.id WHERE ur.role_id=:roleId ", nativeQuery = true)
	List<User> getListByRoleId(Integer roleId);

	@Query(value = "SELECT * from users u LEFT JOIN user_role ur ON ur.usr_id=u.id LEFT JOIN users_journals uj ON uj.user_id= u.id WHERE ur.role_id=:roleId AND uj.journal_id=:journalId", nativeQuery = true)
	List<User> getListByjournaId(Integer journalId, Integer roleId);
	
	@Query("SELECT u from User u where u.isActive=1")
	List<User> getAllActiveUser();

	@Query("SELECT u.institute from User u")
	List<String> getInstitutionByName();
	
	@Query("SELECT u FROM User u WHERE id IN (SELECT userId FROM UserJournal WHERE journalId =:journalId) AND id IN (SELECT user FROM UserRole WHERE role = 2)")
	List<User> getAssignAdmin(Integer journalId); 
	
	@Modifying
	@Query("DELETE FROM UserJournal WHERE userId IN (SELECT user FROM UserRole WHERE role=2) AND journalId =:journalId")
	void deleteExistingManagingEditorsForJournal(Integer journalId);

	@Query("Select u from User u where u.id IN :coAuthorId AND u.isActive=1")
	List<User> getAllActiveUserByUserList(List<Integer> coAuthorId);
		
}
