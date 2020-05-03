package com.yyan.serviceImpl;

import com.yyan.dao.CommentDao;
import com.yyan.pojo.Block;
import com.yyan.pojo.Comment;
import com.yyan.service.CommentService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class CommentServiceImpl extends BaseServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private BlockServiceImpl blockService;


    @Override
    @Transactional // 添加事务
    public void insertComment(Comment comment) {
        comment.setUserId(getUserIdToken());
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
