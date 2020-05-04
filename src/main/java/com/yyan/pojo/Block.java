package com.yyan.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Block {

    public String id; // 区块 id
    public String userId; // 创建人
    private String userName; //  加密文件路径
    public String preHash; // 前节点hash
    public String departmentId; // 前节点hash
    private String data; //  加密类容
    private long timeStamp; //时间搓 1/1/1970.
    private int nonce; // 随机数
    public String hash; // 当前节点hash
    public String category; // 当前节点类型
    public Integer height; // 区块高度

    private Date createTime;  // 创建时间
    private Date updateTime;  // 修改时间
    private User user;// 区块创建人

}