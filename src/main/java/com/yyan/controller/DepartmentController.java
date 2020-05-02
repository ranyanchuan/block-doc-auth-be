package com.yyan.controller;

import com.yyan.serviceImpl.DepartmentServiceImpl;
import com.yyan.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/department")
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentServiceImpl  departmentService;

    /**
     * 查询部门
     */
    @RequestMapping("/select")
    @ResponseBody
    public Map<String, Object> getDepartment(@RequestBody Map map) {
        try {
            return this.buildSuccess(this.departmentService.selectListDepartment(map));
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }



}
