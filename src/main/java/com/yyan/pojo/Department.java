package com.yyan.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Department {

    private String id;
    private String parentId;
    private String title;

    private List<Department> children = new ArrayList<>();


    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间


    public Department(String id, String title, String parentId) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
    }
}
