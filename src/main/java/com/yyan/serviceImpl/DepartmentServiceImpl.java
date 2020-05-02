package com.yyan.serviceImpl;

import com.yyan.dao.DepartmentDao;
import com.yyan.pojo.Department;
import com.yyan.service.DepartmentService;
import com.yyan.utils.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    private List<Department> getThree(List<Department> list, String parentId) {
        //获取所有子节点
        List<Department> childTreeList = getChildTree(list, parentId);
        for (Department dept : childTreeList) {
            dept.setChildren(getThree(list, dept.getId()));
        }
        return childTreeList;
    }


    // 获取子树
    private List<Department> getChildTree(List<Department> list, String id) {
        List<Department> childTree = new ArrayList<>();
        for (Department dept : list) {
            if (dept.getParentId().equals(id)) {
                childTree.add(dept);
            }
        }
        return childTree;
    }


    @Override
    public List<Department> selectListDepartment(Map map) {
        return departmentDao.selectListDepartment();
    }
}
