package com.yyan.serviceImpl;

import com.yyan.dao.AuthDao;
import com.yyan.pojo.Auth;
import com.yyan.pojo.Block;
import com.yyan.service.AuthService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
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
        auth.setDepartmentId(getDepartmentIdByToken());
        auth.setUserId(getUserIdToken());
        authDao.insertAuth(auth);
    }

    @Override
    @Transactional // 添加事务
    public void updateAuth(Auth auth) {
        authDao.updateAuth(auth);
        Map map = new HashMap();
        map.put("id", auth.getId());
        List<Map> list = authDao.selectListAuth(checkPageSize(map));
        // 插入区块
        Block block = new Block();
        block.setCategory("approval");

        block.setData(list.toString());
        blockService.insertBlock(block);

    }

    @Override
    public Map<String, Object> selectListAuth(Map map) {
        map.put("departmentId",getDepartmentIdByToken());
        List<Map> list = authDao.selectListAuth(checkPageSize(map));
        Integer count = authDao.countListAuth(checkPageSize(map));
        return this.queryListSuccess(list, count, map); //查询成功
    }
}
