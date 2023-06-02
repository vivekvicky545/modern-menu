package com.modernmenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.modernmenu.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

	User findByUserName(String userName);
	
}
