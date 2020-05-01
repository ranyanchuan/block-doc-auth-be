package com.yyan.controller;

import com.yyan.pojo.Comment;
import com.yyan.serviceImpl.CommentServiceImpl;
import com.yyan.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/api/comment")
public class CommentController  extends BaseController {

    @Autowired
    private CommentServiceImpl commentService;

    /**
     *添加
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> addComment(@RequestBody Comment Comment) {
        try {
            this.commentService.insertComment(Comment);
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
    public Map<String, Object> getComment(@RequestBody Map map) {
        try {
            return this.buildSuccess(this.commentService.selectListComment(map));
        } catch (Exception exp) {
            return this.buildError(exp.getMessage());
        }
    }


}
