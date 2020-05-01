package com.yyan.serviceImpl;

import com.yyan.dao.DepartmentDao;
import com.yyan.service.DepartmentService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class DepartmentServiceImpl extends BaseServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;


    @Override
    public Map<String, Object> selectListDepartment(Map map) {
        return null;
    }
}
