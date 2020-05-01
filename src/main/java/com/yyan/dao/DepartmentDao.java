package com.yyan.dao;

import com.yyan.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepartmentDao {
    // 查询
    List<Map> selectListDepartment(Map map);
    Integer countListDepartment(Map map); // 查询数量


}
