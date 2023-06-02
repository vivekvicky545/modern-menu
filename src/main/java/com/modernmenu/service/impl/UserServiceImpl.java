package com.modernmenu.service.impl;

import org.springframework.stereotype.Service;

import com.modernmenu.entity.User;
import com.modernmenu.repository.UserRepository;
import com.modernmenu.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	
	private final UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		userRepository.saveAndFlush(user);
	}

	@Override
	public User getUser(String userName) {
		return userRepository.findByUserName(userName);
	}

}
