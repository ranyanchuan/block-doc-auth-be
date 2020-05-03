package com.yyan.pojo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Data
public class Comment {
    private String id;
    private String title;
    private String userId;
    private String userName;
    private String docId;
    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间

    @Override
    public String toString() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", docId='" + docId + '\'' +
                ", createTime=" + formatter.format(createTime) +
                ", updateTime=" + formatter.format(updateTime) +
                '}';
    }
}
