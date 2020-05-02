package com.yyan.dao;

import com.yyan.pojo.Auth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AuthDao {
    //  添加
    void insertAuth(Auth auth);

    // 查询
    List<Map> selectListAuth(Map map);
    Integer countListAuth(Map map); // 查询数量

    void updateAuth(Map map);


}
