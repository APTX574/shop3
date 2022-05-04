package com.community.service;

import com.community.dao.UserMapper;
import com.community.entity.User;
import com.community.util.CommunityConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author aptx
 */
@Service
public class UserServer implements CommunityConstant {

	private final Random random = new Random();

	Logger logger = LoggerFactory.getLogger(UserServer.class);

	@Autowired
	private UserMapper userMapper;

	public User getUserById(int id) {
		return userMapper.getUserById(id);
	}

	public User getUserByAddress(String address) {
		return userMapper.getUserByAdd(address);
	}

	public int insertUser(User user) {
		return userMapper.insertUser(user);
	}

	 public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}

	public Boolean register(User user) {
		insertUser(user);
		return true;
	}

	public boolean login(String name, String passwd) {

		if (passwd == null) {
			return false;
		}
		User userByName = userMapper.getUserByName(name);
		return passwd.equals(userByName.getPassword());

	}

}
