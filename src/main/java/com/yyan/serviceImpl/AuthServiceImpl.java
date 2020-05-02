package com.yyan.serviceImpl;

import com.yyan.dao.AuthDao;
import com.yyan.pojo.Auth;
import com.yyan.pojo.Block;
import com.yyan.service.AuthService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AuthServiceImpl extends BaseServiceImpl implements AuthService {
    @Autowired
    private AuthDao authDao;
    @Autowired
    private BlockServiceImpl blockService;

    @Override
    public void insertAuth(Auth auth) {
        auth.setState("待审批");
        authDao.insertAuth(auth);
    }

    @Override
    @Transactional // 添加事务
    public void updateAuth(Auth auth) {
        auth.setState("可阅读");
        authDao.updateAuth(auth);
        // 插入区块
        Block block = new Block();
        block.setCategory("approval");
        block.setData(auth.toString());
        blockService.insertBlock(block);

    }

    @Override
    public Map<String, Object> selectListAuth(Map map) {
        return null;
    }
}
