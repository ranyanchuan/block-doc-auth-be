package com.yyan.dao;

import com.yyan.pojo.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentDao {

    //  添加
    void insertDepartment(Department department);

    // 查询
    List<Department> selectListDepartment();


}
