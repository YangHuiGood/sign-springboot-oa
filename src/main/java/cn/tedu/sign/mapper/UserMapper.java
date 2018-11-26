package cn.tedu.sign.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.sign.pojo.User;

public interface UserMapper {

	User getUserByUP(@Param("userName") String userName, @Param("userPassword") String userPassword);

}
