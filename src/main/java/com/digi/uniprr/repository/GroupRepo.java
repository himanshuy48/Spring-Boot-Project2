package com.digi.uniprr.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Groups;



public interface GroupRepo extends JpaRepository<Groups, Integer>
{
	Groups findByGroupName(String groupName);

	@Query(value="SELECT * FROM group_details a WHERE a.id=:id", nativeQuery=true)
	List <Groups> getgroupsById(Integer id);
	
	/*
	 * @Query(value="SELECT * FROM group_details a WHERE a.id=:id",
	 * nativeQuery=true) Groups getByRoleIdForGroup(Integer id);
	 */

	/*
	 * @Query("SELECT u FROM Groups u WHERE u.role.id=:id") List<Groups>
	 * getGroupDetailsByRoleId( Integer id);
	 */
	
	@Query("select g from Groups g where g.id=:id")
	List<Groups> getGroupById(Integer id);
	
	@Modifying
    @Query("delete from Groups g where g.id=:id")
	public void deleteGroupRoleById(Integer id);
}
