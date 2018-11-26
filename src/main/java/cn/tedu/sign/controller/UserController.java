package cn.tedu.sign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.tedu.common.util.ObjectUtil;
import cn.tedu.sign.mapper.UserMapper;
import cn.tedu.sign.pojo.User;

@RestController
@RequestMapping("/sign")
public class UserController {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 登录
	 * 
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/login")
	// http://localhost:8089/sign/login?userName=admin&userPassword=1
	public String login(String userName, String userPassword) throws Exception {
		System.out.println(userName);
		User user = userMapper.getUserByUP(userName, userPassword);

		return ObjectUtil.mapper.writeValueAsString(user);
	}
}