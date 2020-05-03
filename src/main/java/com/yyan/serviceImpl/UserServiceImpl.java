package com.yyan.serviceImpl;

import com.yyan.dao.AuthDao;
import com.yyan.dao.BlockDao;
import com.yyan.dao.DocDao;
import com.yyan.dao.UserDao;
import com.yyan.pojo.User;
import com.yyan.service.UserService;
import com.yyan.utils.BaseServiceImpl;
import com.yyan.utils.JwtUtil;
import com.yyan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private AuthDao authDao;
    @Autowired
    private DocDao docDao;

    @Autowired
    private BlockDao blockDao;


    /**
     * 注册用户
     *
     * @param user
     */
    @Override
    public void insertUser(User user) {
        user.setPassword(StringUtil.md5Code(user.getPassword())); //对密码进行 md5
        userDao.insertUser(user);
    }

    /**
     * 更新用户密码
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        // 用户 id
        String userId = getUserIdToken();
        user.setId(userId);
        user.setPassword(StringUtil.md5Code(user.getPassword())); //对密码进行 md5
        userDao.updateUser(user);
    }

    @Override
    public Map selectDashboard() {

        Map map = new HashMap();
        map.put("departmentId", getDepartmentIdByToken());
        // todo 获取任务
        Integer taskCount = authDao.countListAuth(checkPageSize(map));
        // todo 文件管理
        Integer fileCount = docDao.countListDoc(checkPageSize(map));
        // todo 总区块链
        Integer totalCount = blockDao.countListBlock(checkPageSize(map));
        // todo 审批区块
        Map map1 = new HashMap();
        map1.put("departmentId", getDepartmentIdByToken());
        map1.put("category", "approval");
        Integer approvalCount = blockDao.countListBlock(checkPageSize(map1));

        // todo 阅读区块
        Map map2 = new HashMap();
        map2.put("departmentId", getDepartmentIdByToken());
        map2.put("category", "read");
        Integer readCount = blockDao.countListBlock(checkPageSize(map2));
        // todo 评论区块

        Map map3 = new HashMap();
        map3.put("departmentId", getDepartmentIdByToken());
        map3.put("category", "comment");
        Integer commentCount = blockDao.countListBlock(checkPageSize(map3));


        Map rMap = new HashMap();
        rMap.put("taskCount", taskCount);
        rMap.put("fileCount", fileCount);
        rMap.put("totalCount", totalCount);
        rMap.put("approvalCount", approvalCount);
        rMap.put("readCount", readCount);
        rMap.put("commentCount", commentCount);
        return rMap;
    }

    /**
     * 返回登录人信息
     *
     * @param email
     * @param pass
     * @return
     */
    @Override
    public Map login(String email, String pass) {
        String password = StringUtil.md5Code(pass); //对密码进行 md5
        Map map = new HashMap();
        map.put("email", email);
        map.put("password", password);
        // 通过邮箱查询数据库
        User user = userDao.login(map);
        Map resultMap = new HashMap();
        resultMap.put("id", user.getId());
        resultMap.put("name", user.getName());

        // 生成token
        String token = JwtUtil.sign(user.getEmail(), user.getId(), user.getDepartmentId());
        resultMap.put("token", token);

        return resultMap;
    }
}
