package com.yyan.serviceImpl;

import com.yyan.dao.CommentDao;
import com.yyan.dao.DepartmentDao;
import com.yyan.dao.UserDao;
import com.yyan.pojo.Block;
import com.yyan.pojo.Comment;
import com.yyan.pojo.Department;
import com.yyan.pojo.User;
import com.yyan.service.CommentService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentServiceImpl extends BaseServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private BlockServiceImpl blockService;

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional // 添加事务
    public void insertComment(Comment comment) {


        User user = userDao.getUserById(getUserIdToken());
        comment.setUserId(getUserIdToken());
        comment.setUserId(user.getName());
        comment.setId(UUID.randomUUID().toString());
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        commentDao.insertComment(comment);
        Block block = new Block();
        block.setCategory("comment");

        // 插入区块
        block.setData(comment.toString());
        blockService.insertBlock(block);

    }

    @Override
    public Map<String, Object> selectListComment(Map map) {
        return null;
    }
}
