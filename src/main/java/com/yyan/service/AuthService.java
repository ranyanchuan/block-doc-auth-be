package com.yyan.service;

import com.yyan.pojo.Auth;

import java.util.Map;

public interface AuthService {


    void insertAuth(Auth auth);

    void updateAuth(Auth auth);
    void reInsertAuth(Auth auth); // 重新升起

    Map<String, Object> selectListAuth(Map map); // 查询
}
