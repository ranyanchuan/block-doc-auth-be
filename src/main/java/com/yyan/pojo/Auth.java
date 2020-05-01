package com.yyan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Auth {

    private String id;
    private String userId;
    private String docId;
    private Date sTime;
    private Date eTime;
    private Date aTime; // 审批时间
    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间

}
