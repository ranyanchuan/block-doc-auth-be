package com.yyan.service;

import com.yyan.pojo.Auth;

import java.util.Map;

public interface AuthService {


    void insertAuth(Auth Auth);

    void updateAuth(Auth Auth);

    Map<String, Object> selectListAuth(Map map); // 查询
}
