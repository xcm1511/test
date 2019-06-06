package com.example.springDatademo01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springDatademo01.entity.User;
import com.example.springDatademo01.mapper.UserMapper;



@Service
public class UserService {
	

	@Autowired
	UserMapper userMapper;
	
	
	public User selectUser(User user){
		return  userMapper.selectUser(user.getUserName(), user.getPassword());
	}
	
	public int insertUser(User user){
		return userMapper.insertUser(user.getUserName(), user.getPassword());
		
	}


}
