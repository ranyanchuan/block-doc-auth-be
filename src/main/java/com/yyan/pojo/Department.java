package com.yyan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Department {

    private String id;
    private String parentId;
    private String title;

    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间


}
