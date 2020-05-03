package com.yyan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private String id;
    private String title;
    private String userId;
    private String docId;
    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", docId='" + docId + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
