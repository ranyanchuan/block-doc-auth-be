package com.yyan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Auth {

    private String id;
    private String userId;
    private String userName;
    private String docId;
    private String docTitle;
    private String departmentId;
    private String departmentTitle;
    private String state;
    private Date sTime;
    private Date eTime;
    private Date aTime; // 审批时间
    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间

    @Override
    public String toString() {
        return "Auth{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", docId='" + docId + '\'' +
                ", docTitle='" + docTitle + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentTitle='" + departmentTitle + '\'' +
                ", sTime=" + sTime +
                ", eTime=" + eTime +
                ", aTime=" + aTime +
                '}';
    }
}
