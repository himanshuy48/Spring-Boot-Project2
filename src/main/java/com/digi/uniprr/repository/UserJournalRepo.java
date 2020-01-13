package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.UserJournal;

public interface UserJournalRepo extends JpaRepository<UserJournal, Integer> {

	@Query(value = "SELECT * from users u LEFT JOIN user_role ur ON ur.usr_id=u.id LEFT JOIN users_journals uj ON uj.user_id= u.id WHERE ur.role_id=:roleId AND uj.journal_id=:journalId", nativeQuery = true)
	List<UserJournal> getListByjournaId(Integer journalId, Integer roleId);
	
	@Query("Select uj from UserJournal uj where uj.userId=:id")
	List<UserJournal> getUserJournalByUserId(Integer id);
	
	@Query("SELECT uj from UserJournal uj where uj.userId =:userId AND uj.journalId =:journalId")
	UserJournal getUserJournalByJournal(Integer userId, Integer journalId);
	
	@Query("DELETE FROM UserJournal uj WHERE uj.userId=:userId")
	@Modifying
	void deleteUserJournal(Integer userId);
	
}
