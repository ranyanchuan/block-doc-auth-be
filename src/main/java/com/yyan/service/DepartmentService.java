package com.yyan.service;

import com.yyan.pojo.Department;

import java.util.List;
import java.util.Map;


public interface DepartmentService {

    // 查询
    List<Department> selectListDepartment(Map map); // 查询
}
