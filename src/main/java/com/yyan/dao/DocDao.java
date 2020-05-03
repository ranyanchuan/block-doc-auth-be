package com.yyan.dao;

import com.yyan.pojo.Doc;
import com.yyan.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DocDao {

    void insertDoc(Doc doc);

    // 查询
    List<Map> selectListDoc(Map map);
    Integer countListDoc(Map map); // 查询数量


    // 查询
    List<Map> selectListSelfDoc(Map map);
    Integer countListSelfDoc(Map map); // 查询数量

    void deleteDoc(String id);

    
}
