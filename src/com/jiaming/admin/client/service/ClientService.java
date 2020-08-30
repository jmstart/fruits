package com.jiaming.admin.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiaming.entity.User;
import com.jiaming.mapper.UserMapper;

@Service
public class ClientService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userMapper.findAll();
	}

	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.add(user);
	}

	public User findByUid(String uid) {
		// TODO Auto-generated method stub
		return userMapper.findByUid(uid);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	public void deleteUser(String uid) {
		// TODO Auto-generated method stub
		userMapper.delete(uid);
	}

}
