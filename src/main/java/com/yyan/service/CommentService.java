package com.yyan.service;

import com.yyan.pojo.Comment;

import java.util.Map;

public interface CommentService {
    void insertComment(Comment comment);
    Map<String, Object> selectListComment(Map map); // 查询
}
