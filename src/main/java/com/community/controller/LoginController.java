package com.community.controller;

import com.community.entity.User;
import com.community.service.UserServer;
import com.community.util.CommunityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

	@Autowired
	UserServer userServer;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(User user) {
		boolean login = userServer.login(user.getName(), user.getPassword());
		if (login) {
			return CommunityUtil.getJsonString(200, "success");
		}
		return CommunityUtil.getJsonString(500, "error");

	}

	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) {
		user.setCreateTime(new Date());
		return CommunityUtil.getJsonString(200, userServer.register(user).toString());
	}

	@ResponseBody
	@RequestMapping(value = "/getuserbyname", method = RequestMethod.GET)
	public String getUserByname(String name) {
		User userByName = userServer.getUserByName(name);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("user", userByName);
		return CommunityUtil.getJsonString(200, "success", hashMap);
	}

	@ResponseBody
	@RequestMapping(value = "/getuserbyaddress", method = RequestMethod.GET)
	public String getUserByaddress(String address) {
		User userByName = userServer.getUserByAddress(address);
		Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("user", userByName);
		return CommunityUtil.getJsonString(200, "success", hashMap);
	}
}
