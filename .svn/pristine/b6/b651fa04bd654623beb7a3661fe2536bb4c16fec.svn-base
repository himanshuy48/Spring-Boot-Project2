package com.digi.uniprr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.digi.uniprr.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

@Query(value = "select * from role r where r.id=:id", nativeQuery = true)
List<Role> getRoleById(Integer id);

@Query(value = "select * from role r where r.role_name=:roleName", nativeQuery = true)
List<Role> getRoleByName(String roleName);

@Query(value = "SELECT * FROM role_details", nativeQuery = true)
List<Role> getRoleDetails();
}