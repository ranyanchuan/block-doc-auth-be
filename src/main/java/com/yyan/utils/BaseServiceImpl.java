package com.yyan.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;


public class BaseServiceImpl {


    @Autowired
    private HttpSession session;

    @Autowired
    private HttpServletRequest request;

    public String getUserIdToken() {
        String token = request.getHeader("Authorization");// 获取 token
        return JwtUtil.getUserId(token);
    }

    public String getDepartmentIdByToken() {
        String token = request.getHeader("Authorization");// 获取 token
        return JwtUtil.getDepartmentId(token);
    }


    public String getEmailByToken() {
        String token = request.getHeader("Authorization");// 获取 token
        return JwtUtil.getEmail(token);
    }

    /**
     * 获取用户 id
     *
     * @return
     */
    public String getUserIdSession() {
        return (String) session.getAttribute("userId");
    }


    //  查询成功数据组装
    public Map<String, Object> queryListSuccess(Object data, Integer count, Map param) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", data);
        map.put("pageNumber", param.get("pageIndex"));
        map.put("pageSize", param.get("size"));
        map.put("total", count);
        return map;
    }

    //  去掉实体中没有必要的字段
    public List<?> queryListClearField(List<?> list, String[] arr) {
        List<Map<String, Object>> newList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = new HashMap<>();
            map.putAll(BeanMap.create(object));
            for (String key : arr) {
                map.remove(key);// 去掉不必要的字段
            }
            newList.add(map);
        }
        return newList;
    }


    /**
     * 批量插入数据，为数据添加 id,createTime,updateTime
     *
     * @param list
     * @return
     */
    public List<?> insertListBefore(List<?> list) {
        List<Map<String, Object>> newList = new ArrayList<>();
        for (Object object : list) {
            Map<String, Object> map = new HashMap<>();
            String id = UUID.randomUUID().toString();
            System.out.println("id" + id);
            map.put("id", id); // 添加 id
            map.put("updateTime", new Date()); // 添加创建时间
            map.put("createTime", new Date()); // 添加修改时间
            newList.add(map);
        }
        return newList;

    }


    public Map checkPageSize(Map map) {

        Integer size = map.get("size") != null ? (Integer) map.get("size") : 10;
        Integer pageIndex = map.get("pageIndex") != null ? (Integer) map.get("pageIndex") : 0;
        map.put("size", size);
        map.put("pageIndex", pageIndex);
        return map;
    }


}
