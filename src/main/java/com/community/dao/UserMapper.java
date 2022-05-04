package com.community.dao;

import com.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author aptx
 */
@Mapper
public interface UserMapper {
	User getUserById(int id);

	User getUserByAdd(String address);
	User getUserByName(String name);

	int insertUser(User user);

}
