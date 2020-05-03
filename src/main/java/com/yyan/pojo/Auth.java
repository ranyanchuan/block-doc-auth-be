package com.yyan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Auth implements Serializable {

    private String id;
    private String userId;
    private String userName;
    private String docId;
    private String docTitle;
    private String docAbs;
    private String departmentId;
    private String departmentTitle;
    private String state;
    private String note;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date sTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date eTime;
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date aTime; // 审批时间
    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", docId='" + docId + '\'' +
                ", docTitle='" + docTitle + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentTitle='" + departmentTitle + '\'' +
                ", note=" + note +
                ", sTime=" + sTime +
                ", eTime=" + eTime +
                ", aTime=" + aTime +
                '}';
    }
}
