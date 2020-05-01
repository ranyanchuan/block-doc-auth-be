package com.yyan.dao;

import com.yyan.pojo.Comment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentDao {


    void insertDoc(Comment comment);
    // 查询
    List<Map> selectListComment(Map map);
    Integer countListComment(Map map); // 查询数量

}
