package com.yyan.serviceImpl;

import com.yyan.dao.*;
import com.yyan.pojo.User;
import com.yyan.pojo.UserRole;
import com.yyan.service.UserService;
import com.yyan.utils.BaseServiceImpl;
import com.yyan.utils.JwtUtil;
import com.yyan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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


    @Autowired
    private UserRoleDao userRoleDao;


    /**
     * 注册用户
     *
     * @param user
     */
    @Override
    public void insertUser(User user) {
        user.setPassword(StringUtil.md5Code(user.getPassword())); //对密码进行 md5
        String id = UUID.randomUUID().toString();

        user.setId(id);
        userDao.insertUser(user);

        // 插入 userRole
        UserRole userRole = new UserRole();
        if ("manager".equals(user.getRole())) {
            userRole.setRoleId("1");
        } else {
            userRole.setRoleId("2");
        }
        userRole.setUserId(id);
        userRoleDao.insertUserRole(userRole);

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

        // 获取任务
        Map map0 = new HashMap();
        map0.put("departmentId", getDepartmentIdByToken());
        map0.put("state", "待审批");
        Integer taskCount = authDao.countListAuth(checkPageSize(map0));
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
        resultMap.put("role", user.getRole());
        resultMap.put("email", user.getEmail());
        resultMap.put("departmentId", user.getDepartmentId());

        // 生成token
        String token = JwtUtil.sign(user.getEmail(), user.getId(), user.getDepartmentId());
        resultMap.put("token", token);

        return resultMap;
    }
}
