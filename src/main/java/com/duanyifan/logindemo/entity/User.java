package com.duanyifan.logindemo.entity;

import lombok.Data;

/**
 * 用户实体类
 * 属性和数据库字段一一对应
 */
@Data
public class User {
    private long id; //主键id
    private String username; //用户名
    private String password; //密码
}
