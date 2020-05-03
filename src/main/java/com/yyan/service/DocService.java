package com.yyan.service;

import com.yyan.pojo.Doc;


import java.util.Map;


public interface DocService {


    void insertDoc(Doc doc);

    void deleteDoc(String id);

    Map<String, Object> selectListDoc(Map map); // 查询

    Map<String, Object> selectListSelfDoc(Map map); // 查询

    void insertDocView(Map map);
}
