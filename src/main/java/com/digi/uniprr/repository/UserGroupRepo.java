package com.digi.uniprr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digi.uniprr.bean.UsersBean;
import com.digi.uniprr.model.UserGroup;

public interface UserGroupRepo extends JpaRepository<UserGroup, Integer> {

}
