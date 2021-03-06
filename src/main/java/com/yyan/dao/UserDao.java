package com.yyan.dao;

import com.yyan.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserDao {

    void insertUser(User user);

    void updateUser(User user);

    User login(Map<String, Object> map);

    User getUserById(String id);

}
