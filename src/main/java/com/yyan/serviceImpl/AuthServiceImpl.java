package com.yyan.serviceImpl;

import com.yyan.dao.AuthDao;
import com.yyan.pojo.Auth;
import com.yyan.service.AuthService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl extends BaseServiceImpl implements AuthService {
    @Autowired
    private AuthDao authDao;

    @Override
    public void insertAuth(Auth Auth) {

    }

    @Override
    public void updateAuth(Auth Auth) {
        // todo 插入区块
    }

    @Override
    public Map<String, Object> selectListAuth(Map map) {
        return null;
    }
}
