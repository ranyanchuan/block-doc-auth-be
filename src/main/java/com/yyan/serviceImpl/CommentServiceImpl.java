package com.yyan.serviceImpl;

import com.yyan.dao.CommentDao;
import com.yyan.pojo.Comment;
import com.yyan.service.CommentService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommentServiceImpl extends BaseServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public void insertComment(Comment comment) {
        // todo 插入区块
    }

    @Override
    public Map<String, Object> selectListComment(Map map) {
        return null;
    }
}
