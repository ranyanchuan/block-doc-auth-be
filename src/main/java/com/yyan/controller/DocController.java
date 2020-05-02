package com.yyan.controller;

import com.yyan.pojo.Doc;
import com.yyan.serviceImpl.DocServiceImpl;
import com.yyan.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/doc")
public class DocController extends BaseController {

    @Autowired
    private DocServiceImpl docService;

    /**
     *添加
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> addDoc(@RequestBody Doc doc) {
        try {
            this.docService.insertDoc(doc);
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
    public Map<String, Object> getDoc(@RequestBody Map map) {
        try {
            return this.buildSuccess(this.docService.selectListDoc(map));
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


    /**
     *删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String, Object> delDoc(@RequestParam String id) {
        try {
            this.docService.deleteDoc(id);
            return this.buildSuccess();
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }

}
