package com.yyan.controller;

import com.yyan.pojo.Auth;
import com.yyan.serviceImpl.AuthServiceImpl;
import com.yyan.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/auth")
public class AuthController extends BaseController {

    @Autowired
    private AuthServiceImpl authService;

    /**
     *添加
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> addAuth(@RequestBody Auth auth) {
        try {
            this.authService.insertAuth(auth);
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


    /**
     * 根据条件查询
     */
    @RequestMapping("/select")
    @ResponseBody
    public Map<String, Object> getAuth(@RequestBody Map map) {
        try {
            return this.buildSuccess(this.authService.selectListAuth(map));
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


    /**
     *修改
     */
    @RequestMapping("/update")
    @ResponseBody
    public Map<String, Object> updAuth(@RequestBody Auth auth) {
        try {
            this.authService.updateAuth(auth);
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }
}
